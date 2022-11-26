package com.example.quizzfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizzfinal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NonNls;

public class MainActivity extends AppCompatActivity {
    private Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Truy cap vao Fragment Container View
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        //Tu Fragment Container View lay ra controller cua no
        NavController navController = navHostFragment.getNavController();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        //Them controller vao bottonNav
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.taskbar, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Navigation Component: Navgraph, ContainerView, Controler
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        switch (item.getItemId()) {
            case R.id.toFeedbackFragment:
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "20021556@vnu.edu.vn" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Minh" + "");
                startActivity(Intent.createChooser(Email, "Send Feedback"));
                return true;
            case R.id.toInformationGameFragment:
                //Mo HelpFragment
                navController.navigate(R.id.informationGameFragment);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}