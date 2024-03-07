// Generated by view binder compiler. Do not edit!
package com.example.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class DialogCustomBackConfirmationBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dialogDescription;

  @NonNull
  public final TextView dialogTitle;

  @NonNull
  public final Button noButton;

  @NonNull
  public final Button yesButton;

  private DialogCustomBackConfirmationBinding(@NonNull LinearLayout rootView,
      @NonNull TextView dialogDescription, @NonNull TextView dialogTitle, @NonNull Button noButton,
      @NonNull Button yesButton) {
    this.rootView = rootView;
    this.dialogDescription = dialogDescription;
    this.dialogTitle = dialogTitle;
    this.noButton = noButton;
    this.yesButton = yesButton;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogCustomBackConfirmationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogCustomBackConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_custom_back_confirmation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogCustomBackConfirmationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialog_description;
      TextView dialogDescription = ViewBindings.findChildViewById(rootView, id);
      if (dialogDescription == null) {
        break missingId;
      }

      id = R.id.dialog_title;
      TextView dialogTitle = ViewBindings.findChildViewById(rootView, id);
      if (dialogTitle == null) {
        break missingId;
      }

      id = R.id.no_button;
      Button noButton = ViewBindings.findChildViewById(rootView, id);
      if (noButton == null) {
        break missingId;
      }

      id = R.id.yes_button;
      Button yesButton = ViewBindings.findChildViewById(rootView, id);
      if (yesButton == null) {
        break missingId;
      }

      return new DialogCustomBackConfirmationBinding((LinearLayout) rootView, dialogDescription,
          dialogTitle, noButton, yesButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}