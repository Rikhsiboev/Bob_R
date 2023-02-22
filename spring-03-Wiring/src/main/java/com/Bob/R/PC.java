package com.Bob.R;

import com.Bob.R.casefactory.Case;
import com.Bob.R.monitorfactory.Monitor;
import com.Bob.R.motherboardfactory.Motherboard;
import lombok.Getter;

@Getter
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
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
