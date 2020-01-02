package detekt.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtImportDirective

class ImportControl(
    config: Config = Config.empty
) : Rule(config) {

    private val disallowedImports = listOf("java.util.ArrayList")

    override val issue = Issue("ImportControl",
        Severity.Style, "Don't import illegal imports",
        Debt.FIVE_MINS)

    override fun visitImportDirective(importDirective: KtImportDirective) {
        val import = importDirective.importPath?.pathStr

        if (disallowedImports.contains(import)) {
            report(CodeSmell(issue, Entity.from(importDirective),
                "Importing '$import' which is not allowed."))
        }
    }
}