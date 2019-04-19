package dragon.bakuman.iu.canteen;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ProductImagesAdapter extends PagerAdapter {

    private List<String> productImages;

    public ProductImagesAdapter(List<String> productImages) {
        this.productImages = productImages;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productImage = new ImageView(container.getContext());

//        Animation animation = AnimationUtils.loadAnimation(container.getContext(), R.anim.fade_in);
//        productImage.setAnimation(animation);

        Glide.with(container.getContext()).load(productImages.get(position)).apply(new RequestOptions().placeholder(R.drawable.placeholdericon)).into(productImage);



        container.addView(productImage, 0);
        return productImage;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ImageView) object);

    }


    @Override
    public int getCount() {
        return productImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}