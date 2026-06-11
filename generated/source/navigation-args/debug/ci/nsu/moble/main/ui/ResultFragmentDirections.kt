package ci.nsu.moble.main.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ci.nsu.moble.main.R

public class ResultFragmentDirections private constructor() {
  public companion object {
    public fun actionResultFragmentToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_resultFragment_to_mainFragment)
  }
}
