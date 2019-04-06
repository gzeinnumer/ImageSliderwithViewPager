package com.gzeinnumer.imagesliderwithviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//todo 4
public class AdapterViewPager extends PagerAdapter {

    //todo 5
    private Context context;
    private LayoutInflater layoutInflater;
    ViewPager vp;
    private Integer[] images ={
            R.drawable.logo_gw2,
            R.drawable.logo_gw2,
            R.drawable.logo_gw2
    };

    public AdapterViewPager(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //todo 6
        View view = layoutInflater.inflate(R.layout.item, null);

        //todo 8
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        vp = (ViewPager) container;
        vp.addView(view, 0);

        vp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < getCount()-1; i++) {
                            final int value = i;
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    vp.setCurrentItem(value, true);
                                }
                            });
                        }
                    }
                };
                new Thread(runnable).start();

            }
        });

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
