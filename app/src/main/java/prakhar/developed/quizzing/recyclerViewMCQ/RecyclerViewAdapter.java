package prakhar.developed.quizzing.recyclerViewMCQ;

//--------------------------------------------------------------------------------------------------

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import prakhar.developed.quizzing.R;

//--------------------------------------------------------------------------------------------------
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //--------------------------------------------------------------------------------------------------
    private List<RecyclerViewModel> MCQ;
    private Context context;
    public ArrayList<Integer> selectedOptions;


    //--------------------------------------------------------------------------------------------------
    public RecyclerViewAdapter(List<RecyclerViewModel> list, Context context) {
        this.MCQ = list;
        this.context = context;
    }

    //--------------------------------------------------------------------------------------------------
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_mcq_design, parent, false);
        return new ViewHolder(view);
    }

    //--------------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String lable = MCQ.get(position).getLable();
        String optionKey1Lable = MCQ.get(position).getOptionKey1();
        String optionKey2Lable = MCQ.get(position).getOptionKey2();
        String optionKey3Lable = MCQ.get(position).getOptionKey3();
        String optionKey4Lable = MCQ.get(position).getOptionKey4();
        holder.setData(lable, optionKey1Lable, optionKey2Lable, optionKey3Lable, optionKey4Lable);

    }

    //--------------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return MCQ.size();
    }

    //--------------------------------------------------------------------------------------------------
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lable;
        Button option1;
        Button option2;
        Button option3;
        Button option4;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lable = itemView.findViewById(R.id.lable);
            option1 = itemView.findViewById(R.id.buttonOption1);
            option2 = itemView.findViewById(R.id.buttonOption2);
            option3 = itemView.findViewById(R.id.buttonOption3);
            option4 = itemView.findViewById(R.id.buttonOption4);

            selectedOptions = new ArrayList<>();
            option1.setOnClickListener(new View.OnClickListener() {
                int count = 0;

                @Override
                public void onClick(View view) {
                    if (count % 2 == 0) {
                        option1.setBackgroundColor(Color.YELLOW);
                        selectedOptions.add(1);
                    } else if (count % 2 != 0) {
                        option1.setBackgroundColor(Color.rgb(103, 80, 164));
                        selectedOptions.remove(Integer.valueOf(1));
                    }
                    count++;

                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                int count =0;

                @Override
                public void onClick(View view) {
                    if (count % 2 == 0) {
                        option2.setBackgroundColor(Color.YELLOW);
                        selectedOptions.add(2);
                    } else if (count % 2 != 0) {
                        option2.setBackgroundColor(Color.rgb(103, 80, 164));
                        selectedOptions.remove(Integer.valueOf(2));
                    }
                    count++;

                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                int count =0;

                @Override
                public void onClick(View view) {
                    if (count % 2 == 0) {
                        option3.setBackgroundColor(Color.YELLOW);
                        selectedOptions.add(3);
                    } else if (count % 2 != 0) {
                        option3.setBackgroundColor(Color.rgb(103, 80, 164));
                        selectedOptions.remove(Integer.valueOf(3));
                    }
                    count++;
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                int count =0;

                @Override
                public void onClick(View view) {
                    if (count % 2 == 0) {
                        option4.setBackgroundColor(Color.YELLOW);
                        selectedOptions.add(4);
                    } else if (count % 2 != 0) {
                        option4.setBackgroundColor(Color.rgb(103, 80, 164));
                        selectedOptions.remove(Integer.valueOf(4));
                    }
                    count++;
                }
            });
        }

        //--------------------------------------------------------------------------------------------------

        public void setData(String lable, String option1, String option2, String option3, String option4) {


            this.lable.setText(lable);
            this.option1.setText((option1));
            this.option2.setText((option2));
            this.option3.setText((option3));
            this.option4.setText((option4));

        }

//--------------------------------------------------------------------------------------------------
    }
//--------------------------------------------------------------------------------------------------
}
