package br.com.concretesolutions.desafioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.concretesolutions.repository.MoviesRepository;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesRepository.nowPlaying(LanguageType.PT_BR, 1, RegionType.BR);
    }
}
