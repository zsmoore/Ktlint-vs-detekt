package detekt

import detekt.rules.ImportControl
import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import org.junit.Test
import org.junit.Assert.assertEquals

class ImportControlShould {
    @Test
    fun detectIllegalImports() {
        val findings = ImportControl().lint("""
            import java.util.ArrayList
        """.trimIndent())

        assertThat(findings).hasSize(1)
        assertEquals(findings[0].message,
            "Importing 'java.util.ArrayList' which is not allowed."
        )
    }
}