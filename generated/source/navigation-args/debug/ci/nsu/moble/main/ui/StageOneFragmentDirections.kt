package ci.nsu.moble.main.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ci.nsu.moble.main.R

public class StageOneFragmentDirections private constructor() {
  public companion object {
    public fun actionStageOneFragmentToStageTwoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_stageOneFragment_to_stageTwoFragment)
  }
}
