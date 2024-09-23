package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {

    private EditText statusUpdate;
    private Button postButton;
    private LinearLayout newsFeedContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusUpdate = findViewById(R.id.status_update);
        postButton = findViewById(R.id.post_button);
        newsFeedContainer = findViewById(R.id.sample_post);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postStatus();
            }
        });
    }

    private void postStatus() {
        String statusText = statusUpdate.getText().toString().trim();
        if (!statusText.isEmpty()) {
            // Create a new post view
            LinearLayout postLayout = new LinearLayout(this);
            postLayout.setOrientation(LinearLayout.VERTICAL);
            postLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
            postLayout.setPadding(12, 12, 12, 12);

            // User name
            TextView userName = new TextView(this);
            userName.setText("John Doe");
            userName.setTypeface(null, Typeface.BOLD); // Set text style to bold

            // Post content
            TextView postContent = new TextView(this);
            postContent.setText(statusText);
            postContent.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            // Timestamp
            TextView timestamp = new TextView(this);
            timestamp.setText("Just now");
            timestamp.setTextSize(12);
            timestamp.setTextColor(getResources().getColor(android.R.color.darker_gray));

            // Add all views to the post layout
            postLayout.addView(userName);
            postLayout.addView(postContent);
            postLayout.addView(timestamp);

            // Add the new post to the news feed container
            newsFeedContainer.addView(postLayout);

            // Clear the status update field
            statusUpdate.setText("");
        }
    }
}
