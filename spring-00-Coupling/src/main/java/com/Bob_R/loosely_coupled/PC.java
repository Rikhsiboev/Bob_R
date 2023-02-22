package com.Bob_R.loosely_coupled;

import com.Bob_R.loosely_coupled.casefactory.Case;
import com.Bob_R.loosely_coupled.monitorfactory.Monitor;
import com.Bob_R.loosely_coupled.motherboardfactory.Motherboard;


public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt();
    }
}
