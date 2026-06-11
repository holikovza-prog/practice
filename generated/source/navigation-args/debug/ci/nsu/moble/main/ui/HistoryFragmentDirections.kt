package ci.nsu.moble.main.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import ci.nsu.moble.main.R

public class HistoryFragmentDirections private constructor() {
  public companion object {
    public fun actionHistoryFragmentToDetailFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_historyFragment_to_detailFragment)
  }
}
