package ktlint.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class ImportControl : Rule("import-control") {

    private val disallowedImports = listOf("java.util.ArrayList")

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int,
               errorMessage: String,
               canBeAutoCorrected: Boolean) -> Unit) {
        if (node.elementType == KtStubElementTypes.IMPORT_DIRECTIVE) {
            val importDirective = node.psi as KtImportDirective
            val path = importDirective.importPath?.pathStr
            if (disallowedImports.contains(path)) {
                emit(node.startOffset, "Importing illegal import", false)
            }
        }
    }
}