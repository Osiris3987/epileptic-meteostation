package com.example.graphiclibtest1;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.graphiclibtest1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private ConstraintLayout wrapperLayout;
    private View dragView;
    private int dragViewHeight;
    private float lastY;
    private boolean isDragging = false;
    GradientDrawable gradientDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        scrollView = findViewById(R.id.scrollWeatherView);
        /*gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{R.color.gradient_start_color, R.color.gradient_end_color, R.color.gradient_end_color});
        scrollView.setBackground(gradientDrawable);*/
        gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {Color.WHITE, Color.GRAY}
        );
        scrollView.setBackground(gradientDrawable);

        ValueAnimator colorAnimation = ValueAnimator.ofInt(Color.WHITE, Color.GRAY);
        colorAnimation.setDuration(1000); // Длительность анимации - 2,5 секунды
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE); // Бесконечный повтор анимации
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE); // Обратное повторение

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                GradientDrawable gradientDrawable = new GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM,
                        new int[] {(int) animator.getAnimatedValue(), Color.GRAY}
                );
                scrollView.setBackground(gradientDrawable);
            }
        });

        colorAnimation.start();
    }
}

