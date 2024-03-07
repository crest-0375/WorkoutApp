// Generated by view binder compiler. Do not edit!
package com.example.workoutapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.workoutapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout flStart;

  @NonNull
  public final ImageView ivHistory;

  @NonNull
  public final LinearLayout llMainBanner;

  @NonNull
  public final ImageView myImageView;

  @NonNull
  public final ImageView tvBmiCalc;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull FrameLayout flStart,
      @NonNull ImageView ivHistory, @NonNull LinearLayout llMainBanner,
      @NonNull ImageView myImageView, @NonNull ImageView tvBmiCalc) {
    this.rootView = rootView;
    this.flStart = flStart;
    this.ivHistory = ivHistory;
    this.llMainBanner = llMainBanner;
    this.myImageView = myImageView;
    this.tvBmiCalc = tvBmiCalc;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fl_start;
      FrameLayout flStart = ViewBindings.findChildViewById(rootView, id);
      if (flStart == null) {
        break missingId;
      }

      id = R.id.iv_history;
      ImageView ivHistory = ViewBindings.findChildViewById(rootView, id);
      if (ivHistory == null) {
        break missingId;
      }

      id = R.id.ll_main_banner;
      LinearLayout llMainBanner = ViewBindings.findChildViewById(rootView, id);
      if (llMainBanner == null) {
        break missingId;
      }

      id = R.id.my_image_view;
      ImageView myImageView = ViewBindings.findChildViewById(rootView, id);
      if (myImageView == null) {
        break missingId;
      }

      id = R.id.tv_bmi_calc;
      ImageView tvBmiCalc = ViewBindings.findChildViewById(rootView, id);
      if (tvBmiCalc == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, flStart, ivHistory, llMainBanner,
          myImageView, tvBmiCalc);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}