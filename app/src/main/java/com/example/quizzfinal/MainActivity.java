package com.example.quizzfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizzfinal.R;
import com.example.quizzfinal.databinding.ActivityMainBinding;
import com.example.quizzfinal.databinding.FragmentPlayBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NonNls;

public class MainActivity extends AppCompatActivity implements SendDataHome, SendData, SendResult {
    private Button btnFeedback;
    private PlayFragment playFragment = new PlayFragment();
    private LevelFragment levelFragment = new LevelFragment();
    private QuestionFragment questionFragment = new QuestionFragment();
    private ResultFragment resultFragment = new ResultFragment();

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

    @Override
    public void send(String monhoc) {
        Bundle bundle = new Bundle();
        bundle.putString("monhoc", monhoc);
        Log.i("TAG", "send: " + monhoc);
        levelFragment.setArguments(bundle);
    }

    @Override
    public void sendLevel(String cap, String monhoc) {
        Log.d("log", cap);
        Bundle bundle = new Bundle();
        bundle.putString("mess", cap);
        bundle.putString("monhoc", monhoc);
        questionFragment.setArguments(bundle);
    }

    @Override
    public void sendResultFragment(String result, String question, String monhoc, String cap) {
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        bundle.putString("question", question);
        bundle.putString("monhoc", monhoc);
        bundle.putString("cap", cap);

        Log.d("log", result + " " + question);

        resultFragment.setArguments(bundle);
    }
}