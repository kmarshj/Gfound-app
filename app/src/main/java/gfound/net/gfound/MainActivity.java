package gfound.net.gfound;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        if (findViewById(R.id.fragment_container) != null) {

            // 如果是从上一个状态恢复过来, 则不需要做任何事情.
            if (savedInstanceState != null) {
                return;
            }

            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // 获取传入的参数, 将其传输给firstFragment
            firstFragment.setArguments(getIntent().getExtras());

            // 将fragment添加到fragment_container中去.
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}