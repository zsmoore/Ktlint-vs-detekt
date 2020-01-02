package ktlint

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider
import ktlint.rules.ImportControl


class CustomRuleSetProvider : RuleSetProvider {
    override fun get()
        = RuleSet("custom-ktlint-rules", ImportControl())
}