package mvcf;

import java.util.ArrayList;

/**
 *
 * @author ahurtado
 */
public class AModel {

    private ArrayList<AView> views = new ArrayList<>();
    private AView sourceView;

    public void addView(AView view) {
        views.add(view);
    }

    public ArrayList<AView> getViews() {
        return views;
    }

    public void notificar() {
        System.out.println("Notificando");
        for (AView view : views) {
            if (this.sourceView != view) {
                view.actualizar(this);
            }
        }
    }

    /**
     * @return the sourceView
     */
    public AView getSourceView() {
        return sourceView;
    }

    /**
     * @param sourceView the sourceView to set
     */
    public void setSourceView(AView sourceView) {
        this.sourceView = sourceView;
    }

}
