package business.services.svg;

import business.calculations.CalcPart;
import business.entities.Carport;

public class SvgTop extends SVG {

    StringBuilder svg = new StringBuilder();

    private int carportWidth;
    private int carportLength;


    private boolean hasShed;
    private int shedLength;
    private int shedWidth;
    private boolean fullSize;

    public SvgTop(int x, int y, String viewBox, int width, int height, Carport carport) {
        //Starterkode til SVG
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
        this.hasShed = carport.getShed().isHasShed();
        if (hasShed) {
            this.hasShed = true;
        }
        if (carport.getShed().isFullSize()) {
            this.fullSize = true;
        }

        this.carportLength = carport.getCarportLength();
        this.carportWidth = carport.getCarportWidth();
        this.shedLength = carport.getShed().getShedLength();
        this.shedWidth = carport.getShed().getShedWidth();
    }

    public String generateSvgTop() {
        omkreds();
        arrowOmkreds();
        remme();
        rafters();//spær
        raftersArrowsText();
        posts();
        perforatedTape();//hulbånd
        if (hasShed) {
            addShed();
        }
        return svg + "</svg>";
    }


    private void perforatedTape() {//hulbånd
        if (hasShed) {
            //mod højre øverste højrne
            addStripedLine(carportLength - shedWidth - 30 + 100, 155,
                    135, (carportWidth - 35 + 100), svg);
            //mod venstre øvereste hjørne
            addStripedLine(155, (carportLength - 190 - 30 + 100), 135, (carportWidth - 35 + 100), svg);
        } else {
            //mod højre øverste højrne
            addStripedLine((carportLength - 55 + 100), 155, 135, (carportWidth - 35 + 100), svg);
            //mod venstre øvereste hjørne
            addStripedLine(155, (carportLength - 55 + 100), 135, (carportWidth - 35 + 100), svg);
        }
    }

    public void remme() {

        //Øverste rem
        addRect(100, 135, 5, carportLength - 5, svg);
        //Nedereste rem
        addRect(100, carportWidth - 35 + 100, 5, carportLength - 5, svg);
    }


    //Laver omridset af carporten
    public void omkreds() {
        addRect(100, 100, carportWidth, carportLength - 5, svg);
    }

    //pile og mål til side og bundlinje
    public void arrowOmkreds() {
        //pile og mål til side
        addArrowAndText(50, 100, 50, carportWidth + 100,
                30, ((carportWidth / 2) + 100), carportWidth, svg);
        //pile og mål til bundlinje
        addArrowAndText(100, (100 + 30 + carportWidth), (carportLength + 100), (100 + 30 + carportWidth),
                (100 + (carportLength / 2)), (100 + carportWidth + 25), carportLength, svg);
    }

    public void rafters() {//spær
        int raftersAmount = CalcPart.calcRafters(carportLength, 55);//Fog standards
        for (int i = 0; i < raftersAmount; i++) {
            addRect(100 + (55 * i), 100, carportWidth, 4.5, svg);
        }
    }

    //adder omrids af skur
    public void addShed() {
        if (fullSize) {
            addRect(carportLength - 30 - 190 + 100, 130, 5, 190, svg);
            addRect(carportLength - 30 - 190 + 100, 130, carportWidth - 60, 5, svg);
            addRect(carportLength - 30 + 100, 130, carportWidth - 60, 5, svg);
            addRect(carportLength - 30 - 190 + 100, carportWidth - 30 + 100, 5, 190, svg);
        } else if (!fullSize) {
            addRect(carportLength - 30 - 190 + 100, 130, 5, 190, svg);
            addRect(carportLength - 30 - 190 + 100, 130, (carportWidth - 60) / 2, 5, svg);
            addRect(carportLength - 30 + 100, 130, (carportWidth - 60) / 2, 5, svg);
            addRect(carportLength - 30 - 190 + 100, ((carportWidth) / 2) + 100, 5, 190, svg);
        }
    }

    //TODO: Modulo --> fix spær text på bagereste spær hvis %55 != 0
    public void raftersArrowsText() {
        int raftersAmount = CalcPart.calcRafters(carportLength, 55);//Fog standards
        int x2 = 0; //for line field
        int x = 0;//for text field

        for (int i = 0; i < raftersAmount; i++) {
            x2 = (100 + (55 * (i + 1)));
            x = (110 + (55 * i));
            if (i == raftersAmount - 1) {//Makes sure that the line stops at carport width
                x2 = (100 + (55 * (i)));
                x = (110 + (55 * (i - 1)));

            }
            addArrowAndText((100 + (55 * i)), 70, x2, 70, x, 50, 55, svg);
        }
    }

    public void posts() {
        int postsAmount = CalcPart.calcPostAmount(carportLength, hasShed);
        int remainingLength = carportLength - 100 - 30;

        if (hasShed) {
            remainingLength = remainingLength - 190;
            int remainingPosts = postsAmount - 9;
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / (remainingPosts);
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addRect(200, 130, 9.7, 9.7, svg);
            addRect(200, carportWidth + 100 - 30, 9.7, 9.7, svg);
            addRect(carportLength - 30 + 100, 130, 9.7, 9.7, svg);
            addRect(carportLength - 30 + 100, carportWidth + 100 - 30, 9.7, 9.7, svg);
            addRect(carportLength - 30 + 100, (carportWidth / 2) + 100, 9.7, 9.7, svg);
            addRect(carportLength - 30 - 190 + 100, 130, 9.7, 9.7, svg);
            addRect(carportLength - 30 - 190 + 100, carportWidth + 100 - 30, 9.7, 9.7, svg);
            addRect(carportLength - 30 - 190 + 100, (carportWidth / 2) + 100, 9.7, 9.7, svg);
            if (postsAmount > 10) {
                addRect(200 + spaceBetweenPosts, 130, 9.7, 9.7, svg);
                addRect(200 + spaceBetweenPosts, carportWidth + 100 - 30, 9.7, 9.7, svg);
            }

        } else {
            int remainingPosts = ((postsAmount - 4) / 2) + 1;
            int spaceBetweenPosts = 0;
            if (remainingPosts > 0) {
                spaceBetweenPosts = remainingLength / (remainingPosts);
            } else {
                spaceBetweenPosts = remainingLength;
            }
            addRect(200, 130, 9.7, 9.7, svg);
            addRect(200, carportWidth + 100 - 30, 9.7, 9.7, svg);
            addRect(carportLength - 30 + 100, 130, 9.7, 9.7, svg);
            addRect(carportLength - 30 + 100, carportWidth + 100 - 30, 9.7, 9.7, svg);
            if (postsAmount > 4) {
                addRect(200 + spaceBetweenPosts, 130, 9.7, 9.7, svg);
                addRect(200 + spaceBetweenPosts, carportWidth + 100 - 30, 9.7, 9.7, svg);
            }
            if (postsAmount > 6) {
                addRect(200 + (spaceBetweenPosts * 2), 130, 9.7, 9.7, svg);
                addRect(200 + (spaceBetweenPosts * 2), carportWidth + 100 - 30, 9.7, 9.7, svg);
            }
        }
    }

}
