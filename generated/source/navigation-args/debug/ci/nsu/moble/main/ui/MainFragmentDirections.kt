package ci.nsu.moble.main.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ci.nsu.moble.main.R

public class MainFragmentDirections private constructor() {
  public companion object {
    public fun actionMainFragmentToStageOneFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_stageOneFragment)

    public fun actionMainFragmentToHistoryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_historyFragment)
  }
}
