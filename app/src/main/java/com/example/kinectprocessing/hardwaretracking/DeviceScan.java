package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DeviceScan extends Activity {

    public final int CUSTOMIZED_REQUEST_CODE = 0x0000ffff;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_scan);

        Button next = findViewById(R.id.scan_btn);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ContinuousCaptureActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

//        Button frag = findViewById(R.id.scan_btn2);
//        frag.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), ScanFragment.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });
    }


    public void scanBarcode(View view) {
        new IntentIntegrator(this).initiateScan();
    }


    //
//    public void scanBarcodeWithCustomizedRequestCode(View view) {
//        new IntentIntegrator(this).setRequestCode(CUSTOMIZED_REQUEST_CODE).initiateScan();
//    }
//
//    public void scanBarcodeInverted(View view){
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.addExtra(Intents.Scan.SCAN_TYPE, Intents.Scan.INVERTED_SCAN);
//        integrator.initiateScan();
//    }
//
//    public void scanMixedBarcodes(View view){
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.addExtra(Intents.Scan.SCAN_TYPE, Intents.Scan.MIXED_SCAN);
//        integrator.initiateScan();
//    }
//
//
//    public void scanPDF417(View view) {
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.PDF_417);
//        integrator.setPrompt("Scan something");
//        integrator.setOrientationLocked(false);
//        integrator.setBeepEnabled(false);
//        integrator.initiateScan();
//    }
//
//
//    public void scanBarcodeFrontCamera(View view) {
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT);
//        integrator.initiateScan();
//    }
    public void scanContinuous(View view) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        startActivity(intent);
    }
    //
//
//    public void scanCustomScanner(View view) {
//        new IntentIntegrator(this).setOrientationLocked(false).setCaptureActivity(CustomScannerActivity.class).initiateScan();
//    }
//
//
//    public void scanWithTimeout(View view) {
//        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.setTimeout(8000);
//        integrator.initiateScan();
//    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CUSTOMIZED_REQUEST_CODE && requestCode != IntentIntegrator.REQUEST_CODE) {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        switch (requestCode) {
            case CUSTOMIZED_REQUEST_CODE: {
                Toast.makeText(this, "REQUEST_CODE = " + requestCode, Toast.LENGTH_LONG).show();
                break;
            }
            default:
                break;
        }

        IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);

        if(result.getContents() == null) {
            Log.d("MainActivity", "Cancelled scan");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
        } else {
            Log.d("MainActivity", "Scanned");
            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Sample of scanning from a Fragment
     */
    public static class ScanFragment extends Fragment {
        private String toast;

        public ScanFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            displayToast();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_scan, container, false);
            Button scan = (Button) view.findViewById(R.id.scan_from_fragment);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanFromFragment();
                }
            });
            return view;
        }

        public void scanFromFragment() {
            IntentIntegrator.forSupportFragment(this).initiateScan();
        }

        private void displayToast() {
            if(getActivity() != null && toast != null) {
                Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
                toast = null;
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    toast = "Cancelled from fragment";
                } else {
                    toast = "Scanned from fragment: " + result.getContents();
                }

                // At this point we may or may not have a reference to the activity
                displayToast();
            }
        }
    }

}



