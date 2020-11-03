package app.bettermetesttask.testscommon

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.io.File
import java.io.IOException

@Suppress("unused")
class TemporaryFolderExtension @JvmOverloads constructor(private val parentFolder: File? = null) : BeforeEachCallback,
    AfterEachCallback {

    private lateinit var folder: File

    val root: File
        get() {
            return folder
        }

    override fun beforeEach(extensionContext: ExtensionContext) {
        folder = File.createTempFile("junit", "", parentFolder)
        folder.delete()
        folder.mkdir()
    }

    override fun afterEach(extensionContext: ExtensionContext) {
        recursiveDelete(folder)
    }

    @Throws(IOException::class)
    fun newFile(fileName: String): File {
        val file = File(root, fileName)
        if (!file.createNewFile()) {
            throw IOException("a file with the name $fileName already exists in the test folder")
        }
        return file
    }

    fun newFolder(folderName: String): File {
        var file = root
        file = File(file, folderName)
        file.mkdir()
        return file
    }

    private fun recursiveDelete(file: File) {
        val files = file.listFiles()
        if (files != null) {
            for (each in files) {
                recursiveDelete(each)
            }
        }
        file.delete()
    }

}