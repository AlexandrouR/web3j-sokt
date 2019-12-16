import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths

fun main(vararg params: String) {
    for (filePath in params) {

        val fileName = filePath.substringAfterLast("/")
        println("solckt Processing $fileName")
        val solidityFile = SolidityFile(filePath)

        println("Resolving compiler version for $fileName")
        val compilerInstance = solidityFile.getCompilerInstance()

        println("Resolved ${compilerInstance.solcRelease.version} for $fileName")

        compilerInstance.execute()

        println("-------------------------")

    }
}
