package enj0y.calculateurdetaxes;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //Log.d("TAG", "Cliquer sur ID: " + id);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showToast(View view) {
        //Log.d("TAG","Ta cliquer");
        String legume = "patate";
        String nblegume = "3";

        Toast.makeText(this, String.format(getResources().getString(R.string.legume_preferer), nblegume, legume), Toast.LENGTH_LONG).show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }





        TextView totalTextView;
        EditText montantEditText;
        TextView taxesTextView;
        TextView tpsTextView;
        TextView tvqTextView;
        //WebView wView;

        //TextView grosTexte;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //View rootView = inflater.inflate(R.layout.fragment_main3, container, false);


            // SECTION TAXES

            final View fragment1 = inflater.inflate(R.layout.calculateur_taxes, container, false);
            totalTextView = (TextView) fragment1.findViewById(R.id.totalText);
            montantEditText = (EditText) fragment1.findViewById(R.id.montantEdit);
            taxesTextView = (TextView) fragment1.findViewById(R.id.taxesText);
            tpsTextView = (TextView) fragment1.findViewById(R.id.tpsView);
            tvqTextView = (TextView) fragment1.findViewById(R.id.tvqView);


            Button calculerButton = (Button) fragment1.findViewById(R.id.calcButton);
            calculerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShowTaxes();
                }
            });


            // SECTION 2

            View fragment2 = inflater.inflate(R.layout.legumes, container, false);


            // SECTION 3

            View fragment3 = inflater.inflate(R.layout.section_3, container, false);
            //wView = (WebView) fragment3.findViewById(R.id.webView);

            //View fragment = inflater.inflate(R.layout.fragment_blank, container, false);
            //Log.d("FRAGMENT", "Fragment ID: " + getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            //Button lequel = (Button) rootView.findViewById(R.id.btnQuel);
            int quelPage = getArguments().getInt(ARG_SECTION_NUMBER);
            if (quelPage == 1) {
                initSection1();
                return fragment1;
            } else if (quelPage == 2) {
                initSection2();
                return fragment2;
            } else if (quelPage == 3) {
                initSection3();
                //showPage();
                return fragment3;
            }
            //lequel.setText("Test" + quelPage);
            //return rootView;
            //return fragment;
            return fragment1;
        }

        private void initSection3() {
            showPage();
        }

        private void initSection2() {
        }

        private void initSection1() {
        }

        private void showPage() {
            Log.d("URL","Sa load");
            //wView.loadUrl("http://administration.filiale101.xyz/");
            Log.d("URL","C'est loader");
        }

        public void ShowTaxes () {
            //totalTextView.setText("test");
            if (TextUtils.isEmpty(montantEditText.getText())) {
                montantEditText.setError("Entrer un montant");
                return;
            }

            float montantTotal = Float.parseFloat(montantEditText.getText().toString());
            double tps = montantTotal * 0.05;
            double tvq = montantTotal * 0.09975;
            double Taxes = tps + tvq;
            double Total = montantTotal + Taxes;
            DecimalFormat formatTotal = new DecimalFormat("0.00");
            totalTextView.setText(formatTotal.format(Total) + "$");
            tpsTextView.setText("TPS: " + formatTotal.format(tps));
            tvqTextView.setText("TVQ: " + formatTotal.format(tvq));
            taxesTextView.setText("Taxes: " + formatTotal.format(Taxes) + "$");
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.menu_taxes);
                case 1:
                    return getString(R.string.menu_legumes);
                case 2:
                    return getString(R.string.menu_3);
            }
            return null;
        }
    }



}
