package com.themis.ui_programming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Properties;

import es.upm.hcid.pui.assignment.Article;
import es.upm.hcid.pui.assignment.ModelManager;
import es.upm.hcid.pui.assignment.exceptions.AuthenticationError;
import es.upm.hcid.pui.assignment.exceptions.ServerCommunicationError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Properties prop = new Properties();
        prop.setProperty(ModelManager.ATTR_LOGIN_USER, "DEV_TEAM_05");
        prop.setProperty(ModelManager.ATTR_LOGIN_PASS, "90784");
        prop.setProperty(ModelManager.ATTR_SERVICE_URL, "https://sanger.dia.fi.upm.es/pui-rest-news/");
        prop.setProperty(ModelManager.ATTR_REQUIRE_SELF_CERT, "TRUE");

        // Log in
        ModelManager mm = null;
        try{

            mm = new ModelManager(prop);
        }catch (AuthenticationError e) {

            System.exit(-1);
        }

        // get list of articñes for logged user
        List<Article> res = null;
        try {
            res = mm.getArticles(2, 2);
            for (Article article : res) {
                System.out.println(article);
            }
        }catch (ServerCommunicationError e){

        }
    }
}
