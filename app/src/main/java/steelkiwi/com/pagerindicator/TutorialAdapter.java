package steelkiwi.com.pagerindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import steelkiwi.com.pagerindicator.custom.CustomPagerAdapter;

/**
 * Created by yaroslav on 2/20/17.
 */

public class TutorialAdapter extends CustomPagerAdapter<TutorialAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Integer> tutorialImage = new ArrayList<>();

    public TutorialAdapter(Context context) {
        this.context = context;
    }

    @Override
    public TutorialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        if(inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.image_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TutorialAdapter.ViewHolder viewHolder, int position) {
        int image = tutorialImage.get(position);
        viewHolder.ivTutorialImage.setBackgroundResource(image);
    }

    @Override
    public int getCount() {
        return tutorialImage.size();
    }

    public void setTutorialImage(List<Integer> tutorialImage) {
        this.tutorialImage.clear();
        this.tutorialImage.addAll(tutorialImage);
        notifyDataSetChanged();
    }

    public class ViewHolder extends CustomPagerAdapter.ViewHolder {
        RelativeLayout ivTutorialImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTutorialImage = (RelativeLayout) itemView.findViewById(R.id.ivImage);
        }
    }
}
