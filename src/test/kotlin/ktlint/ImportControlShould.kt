package ktlint

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import ktlint.rules.ImportControl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ImportControlShould {
    @Test fun detectIllegalImports() {
        assertThat(ImportControl().lint("""
            import java.util.ArrayList
        """.trimIndent())).containsExactly(
            LintError(1, 1, "import-control",
                "Importing illegal import")
        )
    }
}