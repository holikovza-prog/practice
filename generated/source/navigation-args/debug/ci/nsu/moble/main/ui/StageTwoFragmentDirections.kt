package ci.nsu.moble.main.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ci.nsu.moble.main.R

public class StageTwoFragmentDirections private constructor() {
  public companion object {
    public fun actionStageTwoFragmentToResultFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_stageTwoFragment_to_resultFragment)
  }
}
