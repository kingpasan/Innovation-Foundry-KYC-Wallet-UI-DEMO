package lk.dialog.kyc.kycwallet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WizardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private int[] layouts;
    private TextView[] dots;
    private LinearLayout dotLayout;
    Button btnNext, btnSkip;
    TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        layouts = new int[]{R.layout.wizard_screen_1, R.layout.wizard_screen_2, R.layout.wizard_screen_3};

        init();

        viewPageAdapter = new ViewPageAdapter();
        viewPager.setAdapter(viewPageAdapter);
        viewPager.addOnPageChangeListener(viewListner);
        tabs.setupWithViewPager(viewPager, true);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WizardActivity.this, AuthSelectionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    Intent intent = new Intent(WizardActivity.this, AuthSelectionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);
        tabs = findViewById(R.id.tabLayout);
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if (i == layouts.length - 1) {
                btnNext.setText("Finish");
                btnSkip.setVisibility(View.GONE);
            } else {
                btnNext.setText("Next");
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    public class ViewPageAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
