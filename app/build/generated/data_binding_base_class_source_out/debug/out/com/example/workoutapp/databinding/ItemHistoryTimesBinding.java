// Generated by view binder compiler. Do not edit!
package com.example.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.workoutapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemHistoryTimesBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout llHistoryItem;

  @NonNull
  public final TextView tvHistoryItem;

  @NonNull
  public final TextView tvIndexNumber;

  private ItemHistoryTimesBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout llHistoryItem, @NonNull TextView tvHistoryItem,
      @NonNull TextView tvIndexNumber) {
    this.rootView = rootView;
    this.llHistoryItem = llHistoryItem;
    this.tvHistoryItem = tvHistoryItem;
    this.tvIndexNumber = tvIndexNumber;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemHistoryTimesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemHistoryTimesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_history_times, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemHistoryTimesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout llHistoryItem = (LinearLayout) rootView;

      id = R.id.tv_history_item;
      TextView tvHistoryItem = ViewBindings.findChildViewById(rootView, id);
      if (tvHistoryItem == null) {
        break missingId;
      }

      id = R.id.tv_index_number;
      TextView tvIndexNumber = ViewBindings.findChildViewById(rootView, id);
      if (tvIndexNumber == null) {
        break missingId;
      }

      return new ItemHistoryTimesBinding((LinearLayout) rootView, llHistoryItem, tvHistoryItem,
          tvIndexNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}