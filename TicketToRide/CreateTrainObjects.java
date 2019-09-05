import java.util.ArrayList;
import java.util.HashMap;
/**
 * Creates arraylists for each path
 * adds this path to a hashmap with the 
 * name of the 2 cities as a string value
 *
 * @author Kaley, Ben, Tyler, Zach, Sean
 * @version 4/29/18
 */
public class CreateTrainObjects{
    //create a hashmap instance variable
    //that has a string for the name 
    //of the two cities, and the arraylist
    //of train squares so that you can draw them
    private HashMap <String, ArrayList
    <CreateTrainSquares>> map = new HashMap<>();
    /**
     * CreateTrainObjects constructor to create
     * each cities train route, and put it
     * into an arraylist, and then put that into
     * a hash map for access with a String value
     */
    public CreateTrainObjects(){
        //DANEmark- bremerhaven
        ArrayList<CreateTrainSquares> denBrem
        = new ArrayList<CreateTrainSquares>();
        CreateTrainSquares g1DenBrem = 
            new CreateTrainSquares
            (235, 14, 243, 22, 223, 43, 214, 36);
        CreateTrainSquares g2DenBrem = 
            new CreateTrainSquares
            (211, 40, 221, 45, 206, 73, 197, 68);
        CreateTrainSquares g3DenBrem = 
            new CreateTrainSquares
            (196, 69, 206, 75, 199, 104, 187, 102);
        CreateTrainSquares g4DenBrem = 
            new CreateTrainSquares
            (186, 105, 198, 107, 195, 137, 185, 136);
        CreateTrainSquares g5DenBrem = 
            new CreateTrainSquares
            (185, 140, 196, 140, 198, 169, 188, 171);
        denBrem.add(g1DenBrem);
        denBrem.add(g2DenBrem);
        denBrem.add(g3DenBrem);
        denBrem.add(g4DenBrem);
        denBrem.add(g5DenBrem);
        map.put("BREMERHAVEN_DANEMARK", denBrem);

        //DANEmark - keil
        ArrayList<CreateTrainSquares> denKiel = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares denKiel1 = 
            new CreateTrainSquares
            (285, 28, 292, 21, 317, 39, 311, 46);
        CreateTrainSquares denKiel2 = 
            new CreateTrainSquares
            (311, 49, 321, 54, 308, 82, 299, 78);
        denKiel.add(denKiel1);
        denKiel.add(denKiel2);
        map.put("DANEMARK_KIEL", denKiel);

        //rostock- kiel
        ArrayList<CreateTrainSquares> rostKiel = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares rostKiel1 = 
            new CreateTrainSquares
            (311, 84, 340, 77, 343, 85, 314, 93);
        CreateTrainSquares rostKiel2 = 
            new CreateTrainSquares
            (345, 75, 375, 73, 375, 80, 345, 83);
        CreateTrainSquares rostKiel3 = 
            new CreateTrainSquares
            (380, 71, 410, 75, 410, 85, 377, 81);
        CreateTrainSquares rostKiel4 = 
            new CreateTrainSquares
            (415, 76, 443, 86, 440, 94, 411, 86);
        rostKiel.add(rostKiel1);
        rostKiel.add(rostKiel2);
        rostKiel.add(rostKiel3);
        rostKiel.add(rostKiel4);
        map.put("KIEL_ROSTOCK", rostKiel);

        //kiel- Schwerin
        ArrayList<CreateTrainSquares> kielScher = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kielScher1 = 
            new CreateTrainSquares
            (317, 97, 344, 110, 339, 119, 312, 106);
        CreateTrainSquares kielScher2 = 
            new CreateTrainSquares
            (347, 113, 372, 131, 365, 138, 342, 120);
        CreateTrainSquares kielScher3 = 
            new CreateTrainSquares
            (375, 132, 396, 154, 387, 161, 367, 140);
        kielScher.add(kielScher1);
        kielScher.add(kielScher2);
        kielScher.add(kielScher3);
        map.put("KIEL_SCHWERIN", kielScher);

        //kiel hamburg purple
        ArrayList<CreateTrainSquares> kielHam = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kielHam1 = 
            new CreateTrainSquares
            (297, 109, 309, 108,314, 138, 303, 138);
        CreateTrainSquares kielHam2 = 
            new CreateTrainSquares
            (304, 143, 314, 140,320, 169, 310, 171);
             CreateTrainSquares kielHam123 = 
            new CreateTrainSquares
            (285, 112, 296, 109, 302, 139, 290, 139);
        CreateTrainSquares kielHam223 = 
            new CreateTrainSquares
            (291, 143, 301, 140, 307, 171, 297, 175);
        kielHam.add(kielHam123);
        kielHam.add(kielHam223);
        kielHam.add(kielHam1);
        kielHam.add(kielHam2);
        map.put("HAMBURG_KIEL", kielHam);

        // //keil Hamburg black
        // ArrayList<CreateTrainSquares> kielHam3 = 
            // new ArrayList<CreateTrainSquares>();
       
        // map.put("HAMBURG_KIEL_B", kielHam3);

        //kiel- bremerhaven
        ArrayList<CreateTrainSquares> kielBrem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kielBrem1 = 
            new CreateTrainSquares
            (275, 100, 280, 108,259, 130, 253, 122);
        CreateTrainSquares kielBrem2 = 
            new CreateTrainSquares
            (252, 123, 257, 131, 234, 152, 228, 147);
        CreateTrainSquares kielBrem3 = 
            new CreateTrainSquares
            (228, 146, 234, 155, 209, 174, 204, 168);
        kielBrem.add(kielBrem1);
        kielBrem.add(kielBrem2);
        kielBrem.add(kielBrem3);
        map.put("BREMERHAVEN_KIEL",kielBrem);

        //rostock schwerin
        ArrayList<CreateTrainSquares> rostScherw = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares rostScherw1 = 
            new CreateTrainSquares
            (443, 109, 450, 113, 432, 138, 426, 133);
        CreateTrainSquares rostScherw2 = 
            new CreateTrainSquares
            (424, 135, 430, 140, 411, 164, 405, 161);
        rostScherw.add(rostScherw1);
        rostScherw.add(rostScherw2);
        map.put("ROSTOCK_SCHWERIN", rostScherw);

        //rostock berlin
        ArrayList<CreateTrainSquares> rostBerl = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares rostBerl1 = 
            new CreateTrainSquares
            (465, 112, 470, 103, 494, 123, 488, 131);
        CreateTrainSquares rostBerl2 = 
            new CreateTrainSquares
            (490, 133, 497, 127, 516, 148, 511, 155);
        CreateTrainSquares rostBerl3 = 
            new CreateTrainSquares
            (511, 158, 520, 152, 534, 179, 527, 184);
        CreateTrainSquares rostBerl4 = 
            new CreateTrainSquares
            (526, 187, 538, 183,548, 212,538, 215);
        CreateTrainSquares rostBerl5 =
            new CreateTrainSquares
            (538, 217, 549, 214, 556, 245, 545, 247);
        CreateTrainSquares rostBerl6 = 
            new CreateTrainSquares
            (545, 248, 556, 249, 557, 280, 547, 279);
        rostBerl.add(rostBerl1);
        rostBerl.add(rostBerl2);
        rostBerl.add(rostBerl3);
        rostBerl.add(rostBerl4);
        rostBerl.add(rostBerl5);
        rostBerl.add(rostBerl6);
        map.put("BERLIN_ROSTOCK",rostBerl);

        //Schwerin berlin
        ArrayList<CreateTrainSquares> scheBerl = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares scheBerl1 = 
            new CreateTrainSquares
            (415, 181, 419, 173, 449, 182, 444, 192);
        CreateTrainSquares scheBerl2 = 
            new CreateTrainSquares
            (445, 195, 451, 186, 477, 202, 472, 209);
        CreateTrainSquares scheBerl3 = 
            new CreateTrainSquares
            (473, 212, 481, 204, 503, 224, 497, 233);
        CreateTrainSquares scheBerl4 = 
            new CreateTrainSquares
            (498, 234, 506, 226, 528, 251, 520, 257);
        CreateTrainSquares scheBerl5 = 
            new CreateTrainSquares
            (520, 260, 528, 254, 544, 281,536, 285);
        scheBerl.add(scheBerl1);
        scheBerl.add(scheBerl2);
        scheBerl.add(scheBerl3);
        scheBerl.add(scheBerl4);
        scheBerl.add(scheBerl5);
        map.put("BERLIN_SCHWERIN",scheBerl);

        //schwerin hamburg
        ArrayList<CreateTrainSquares> schwHamb = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares schwHamb1 = 
            new CreateTrainSquares
            (360, 151, 387, 166, 382, 175, 354, 159);
        CreateTrainSquares schwHamb2 = 
            new CreateTrainSquares
            (322, 170, 346, 152, 352, 160, 328, 178);
        schwHamb.add(schwHamb1);
        schwHamb.add(schwHamb2);
        map.put("HAMBURG_SCHWERIN", schwHamb);

        //hamburg berlin blue
        ArrayList<CreateTrainSquares> hambBerl = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hambBerl1 = 
            new CreateTrainSquares
            (333, 180, 361, 196, 354, 204, 328, 190);
        CreateTrainSquares hambBerl2 = 
            new CreateTrainSquares
            (363, 196, 390, 210, 383, 219, 358, 205);
        CreateTrainSquares hambBerl3 = 
            new CreateTrainSquares
            (393, 212, 419, 227, 412, 234, 386, 221);
        CreateTrainSquares hambBerl4 = 
            new CreateTrainSquares
            (421, 228, 448, 242, 444, 251, 416, 236);
        CreateTrainSquares hambBerl5 = 
            new CreateTrainSquares
            (451, 243, 477, 257, 473, 266, 445, 251);
        CreateTrainSquares hambBerl6 = 
            new CreateTrainSquares
            (481, 258, 508, 274, 502, 281, 475, 267);
        CreateTrainSquares hambBerl7 = 
            new CreateTrainSquares
            (509, 274, 535, 289, 532, 297, 504, 283);
            CreateTrainSquares hambBerl11 = 
            new CreateTrainSquares
            (326, 191, 356, 206, 349, 217, 322, 201);
        CreateTrainSquares hambBerl21 = 
            new CreateTrainSquares
            (356, 207, 383, 222, 378, 231,352, 216);
        CreateTrainSquares hambBerl31 = 
            new CreateTrainSquares
            (385, 222, 414, 238, 409, 248, 382, 233);
        CreateTrainSquares hambBerl41 = 
            new CreateTrainSquares
            (416, 239, 442, 252, 437, 262, 410, 246);
        CreateTrainSquares hambBerl51 = 
            new CreateTrainSquares
            (445, 254, 471, 267, 465, 279, 440, 265);
        CreateTrainSquares hambBerl61 = 
            new CreateTrainSquares
            (474, 269, 500, 284, 495, 296, 468, 280);
        CreateTrainSquares hambBerl71 = 
            new CreateTrainSquares
            (504, 286, 530, 299, 526, 308, 498, 294);
        hambBerl.add(hambBerl11);
        hambBerl.add(hambBerl21);
        hambBerl.add(hambBerl31);
        hambBerl.add(hambBerl41);
        hambBerl.add(hambBerl51);
        hambBerl.add(hambBerl61);
        hambBerl.add(hambBerl71);
        hambBerl.add(hambBerl1);
        hambBerl.add(hambBerl2);
        hambBerl.add(hambBerl3);
        hambBerl.add(hambBerl4);
        hambBerl.add(hambBerl5);
        hambBerl.add(hambBerl6);
        hambBerl.add(hambBerl7);
        map.put("BERLIN_HAMBURG", hambBerl);

        //hamburg berlin yellow
        // ArrayList<CreateTrainSquares> hambBerl12 = 
            // new ArrayList<CreateTrainSquares>();
        
       // map.put("BERLIN_HAMBURG", hambBerl12);

        //hamburg hanover red
        ArrayList<CreateTrainSquares> hambHano = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hambHano1 = 
            new CreateTrainSquares
            (297, 196, 307, 197, 300, 226, 289, 224);
        CreateTrainSquares hambHano2 = 
            new CreateTrainSquares
            (289, 227, 298, 229,292, 257,282, 258);
        CreateTrainSquares hambHano3 = 
            new CreateTrainSquares
            (282, 260, 290, 260,284, 292,274, 288);
        CreateTrainSquares hambHano4 = 
            new CreateTrainSquares
            (274, 290, 284, 294, 277, 323, 266, 323);
        hambHano.add(hambHano1);
        hambHano.add(hambHano2);
        hambHano.add(hambHano3);
        hambHano.add(hambHano4);
        //hamburg hanover white
        ArrayList<CreateTrainSquares> hambHano21 = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hambHano11 = 
            new CreateTrainSquares
            (308, 198, 319, 201,313, 232,303, 229);
        CreateTrainSquares hambHano211 = 
            new CreateTrainSquares
            (300, 229, 311, 234, 305, 264, 294, 261);
        CreateTrainSquares hambHano31 = 
            new CreateTrainSquares
            (294, 263, 303, 266, 297, 295, 285, 293);
        CreateTrainSquares hambHano41 = 
            new CreateTrainSquares
            (285, 295, 296, 298, 289, 329, 279, 325);
        hambHano.add(hambHano11);
        hambHano.add(hambHano211);
        hambHano.add(hambHano31);
        hambHano.add(hambHano41);
        map.put("HAMBURG_HANNOVER", hambHano);

        //hamburg bremerhaven
        ArrayList<CreateTrainSquares> hambBrem =
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hambBrem1 = 
            new CreateTrainSquares
            (267, 173, 298, 180, 296, 186,266, 182);
        CreateTrainSquares hambBrem2 =
            new CreateTrainSquares
            (246, 148, 266, 172,258, 177,239, 156);
        CreateTrainSquares hambBrem3 = 
            new CreateTrainSquares
            (213, 178, 236, 158, 242, 163,220, 184);
        hambBrem.add(hambBrem1);
        hambBrem.add(hambBrem2);
        hambBrem.add(hambBrem3);
        map.put("BREMERHAVEN_HAMBURG", hambBrem);

        //hamburg bremen orange
        ArrayList<CreateTrainSquares> hambBremo = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hambBrem1o = 
            new CreateTrainSquares
            (277, 221, 284, 191, 293, 193,287, 224);
        CreateTrainSquares hambBrem2o = 
            new CreateTrainSquares
            (245, 233, 272, 222, 276, 232, 246, 241);
        CreateTrainSquares hambBrem3o = 
            new CreateTrainSquares
            (213, 239, 243, 233,243, 241, 215, 248);
        hambBremo.add(hambBrem1o);
        hambBremo.add(hambBrem2o);
        hambBremo.add(hambBrem3o);
        map.put("BREMEN_HAMBURG" , hambBremo);

        //bremen bremerhaven
        ArrayList<CreateTrainSquares> bremBrem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares bremBrem1 = 
            new CreateTrainSquares
            (190, 199, 201, 199, 205, 228, 194, 230);
        bremBrem.add(bremBrem1);
        map.put("BREMEN_BREMERHAVEN", bremBrem);

        //bremerhaven emden
        ArrayList<CreateTrainSquares> bremEmde = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares bremEmde1 = 
            new CreateTrainSquares
            (157, 159, 184, 173, 180, 181, 153, 167);
        CreateTrainSquares bremEmde2 = 
            new CreateTrainSquares
            (116, 161, 147, 156,148, 166, 120, 170);
        CreateTrainSquares bremEmde3 = 
            new CreateTrainSquares
            (90, 189,  109, 166, 116, 173, 96, 193);
        bremEmde.add(bremEmde1);
        bremEmde.add(bremEmde2);
        bremEmde.add(bremEmde3);
        map.put("BREMERHAVEN_EMDEN", bremEmde);

        //emden bremen
        ArrayList<CreateTrainSquares> emdeBrem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares emdeBrem1 = 
            new CreateTrainSquares
            (98, 205,127, 212, 122, 221,94,213);
        CreateTrainSquares emdeBrem2 = 
            new CreateTrainSquares
            (128, 213, 158, 223,156, 231,126, 222);
        CreateTrainSquares emdeBrem3 = 
            new CreateTrainSquares
            (161, 224, 189, 232,186, 241,158, 233);
        emdeBrem.add(emdeBrem1);
        emdeBrem.add(emdeBrem2);
        emdeBrem.add(emdeBrem3);
        map.put("BREMEN_EMDEN", emdeBrem);

        //emden munsster
        ArrayList<CreateTrainSquares> emdeMuns = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares emdeMuns1 = 
            new CreateTrainSquares
            (82, 219, 90, 216, 98, 246,89, 247);
        CreateTrainSquares emdeMuns2 = 
            new CreateTrainSquares
            (90, 251,100, 249, 108, 275, 98, 279);
        CreateTrainSquares emdeMuns3 = 
            new CreateTrainSquares
            (99, 283,107, 282, 117, 310, 106, 313);
        CreateTrainSquares emdeMuns4 = 
            new CreateTrainSquares
            (108, 316, 116, 314, 125, 340, 114, 343);
        emdeMuns.add(emdeMuns1);
        emdeMuns.add(emdeMuns2);
        emdeMuns.add(emdeMuns3);
        emdeMuns.add(emdeMuns4);
        map.put("EMDEN_MUNSTER", emdeMuns);

        //emden Niederland
        ArrayList<CreateTrainSquares> emdeNieb =
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares emdeNieb1 =
            new CreateTrainSquares
            (47, 234,67, 210,76, 218,55, 240);
        CreateTrainSquares emdeNieb2 = 
            new CreateTrainSquares
            (26, 258,46, 235,53, 241, 34, 265);
        emdeNieb.add(emdeNieb1);
        emdeNieb.add(emdeNieb2);
        map.put("EMDEN_NIEDERLAND", emdeNieb);

        //bremen munster
        ArrayList<CreateTrainSquares> bremMuns = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares bremMuns1 = 
            new CreateTrainSquares
            (183, 257, 192, 263, 175, 289, 166, 283);
        CreateTrainSquares bremMuns2 = 
            new CreateTrainSquares
            (164, 285, 173, 290, 156, 316, 149, 310);
        CreateTrainSquares bremMuns3 =
            new CreateTrainSquares
            (147, 312, 155, 318, 137, 343, 130, 339);
        bremMuns.add(bremMuns1);
        bremMuns.add(bremMuns2);
        bremMuns.add(bremMuns3);
        map.put("BREMEN_MUNSTER", bremMuns);

        //bremen Hannover
        ArrayList<CreateTrainSquares> bremHann = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares bremHann1 = 
            new CreateTrainSquares
            (201, 257, 208, 253, 219, 284, 210, 287);
        CreateTrainSquares bremHann2 = 
            new CreateTrainSquares
            (211, 290, 219, 286, 231, 315, 220, 318);
        CreateTrainSquares bremHann3 = 
            new CreateTrainSquares
            (231, 317, 262, 317, 260, 326, 229, 326);
        bremHann.add(bremHann1);
        bremHann.add(bremHann2);
        bremHann.add(bremHann3);
        map.put("BREMEN_HANNOVER", bremHann);

        //nieberlande munster
        ArrayList<CreateTrainSquares> niebMuns = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares niebMuns1 = 
            new CreateTrainSquares
            (48, 329,78, 339, 73, 347, 45, 336);
        CreateTrainSquares niebMuns2 = 
            new CreateTrainSquares
            (80, 339,108, 348, 104, 358,77, 348);
        niebMuns.add(niebMuns1);
        niebMuns.add(niebMuns2);
        map.put("MUNSTER_NIEDERLAND", niebMuns);

        //nieberlande Dusseldorf
        ArrayList<CreateTrainSquares> niebDuss = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares niebDuss1 = 
            new CreateTrainSquares
            (9, 344, 18, 340,30, 368, 22, 370);
        CreateTrainSquares niebDuss2 = 
            new CreateTrainSquares
            (21, 374, 30, 371, 41, 398,32, 400);
        CreateTrainSquares niebDuss3 = 
            new CreateTrainSquares
            (33, 407, 41, 402, 53, 428,43, 432);
        niebDuss.add(niebDuss1);
        niebDuss.add(niebDuss2);
        niebDuss.add(niebDuss3);
        map.put("DUSSELDORF_NIEDERLAND", niebDuss);

        //berlin hannover
        ArrayList<CreateTrainSquares> berlHann = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares berlHann1 = 
            new CreateTrainSquares
            (493, 312, 523, 311, 524, 322, 495, 322);
        CreateTrainSquares berlHann2 = 
            new CreateTrainSquares
            (460, 313, 490, 313, 490, 322, 460, 323);
        CreateTrainSquares berlHann3 = 
            new CreateTrainSquares
            (426, 315, 457, 313, 458, 323, 428, 324);
        CreateTrainSquares berlHann4 = 
            new CreateTrainSquares
            (394, 318, 424, 315, 425, 327, 394, 326);
        CreateTrainSquares berlHann5 = 
            new CreateTrainSquares
            (362, 318, 391, 316, 390, 325, 361, 326);
        CreateTrainSquares berlHann6 = 
            new CreateTrainSquares
            (328, 319, 357, 319, 358, 328, 328, 330);
        CreateTrainSquares berlHann7 = 
            new CreateTrainSquares
            (293, 322, 323, 320, 324, 328, 295, 330);
        berlHann.add(berlHann1);
        berlHann.add(berlHann2);
        berlHann.add(berlHann3);
        berlHann.add(berlHann4);
        berlHann.add(berlHann5);
        berlHann.add(berlHann6);
        berlHann.add(berlHann7);
        map.put("BERLIN_HANNOVER", berlHann);

        //berlin magdeburg
        ArrayList<CreateTrainSquares> berlMagd = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares berlMagd1 = 
            new CreateTrainSquares
            (513, 341, 532, 320, 541, 324, 519, 348);
        CreateTrainSquares berlMagd2 = 
            new CreateTrainSquares
            (480, 348, 508, 343, 511, 352, 480, 357);
        CreateTrainSquares berlMagd3 = 
            new CreateTrainSquares
            (447, 353, 475, 347, 478, 357, 449, 363);
        berlMagd.add(berlMagd1);
        berlMagd.add(berlMagd2);
        berlMagd.add(berlMagd3);
        map.put("BERLIN_MAGDEBURG", berlMagd);

        //berlin leipzig
        ArrayList<CreateTrainSquares> berlLeip = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares berlLeip1 = 
            new CreateTrainSquares
            (544, 324, 556, 325, 551, 354, 541, 353);
        CreateTrainSquares berlLeip2 = 
            new CreateTrainSquares
            (540, 357, 549, 364, 528, 386, 520, 380);
        CreateTrainSquares berlLeip3 = 
            new CreateTrainSquares
            (518, 382, 524, 387, 506, 410, 497, 404);
        CreateTrainSquares berlLeip4 = 
            new CreateTrainSquares
            (498, 408, 506, 414, 485, 434, 476, 430);
        berlLeip.add(berlLeip1);
        berlLeip.add(berlLeip2);
        berlLeip.add(berlLeip3);
        berlLeip.add(berlLeip4);
        map.put("BERLIN_LEIPZIG", berlLeip);

        //berlin dresden
        ArrayList<CreateTrainSquares> berlDres = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares berlDres1 = 
            new CreateTrainSquares
            (556, 317, 564, 313, 580, 337, 572, 344);
        CreateTrainSquares berlDres2 = 
            new CreateTrainSquares
            (573, 345, 583, 341, 592, 371, 584, 373);
        CreateTrainSquares berlDres3 = 
            new CreateTrainSquares
            (585, 378, 592, 375, 597, 404, 588, 406);
        CreateTrainSquares berlDres4 =
            new CreateTrainSquares
            (590, 410, 599, 408, 598, 437, 590, 437);
        CreateTrainSquares berlDres5 = 
            new CreateTrainSquares
            (589, 444, 598, 443, 595, 472, 586, 470);
        berlDres.add(berlDres1);
        berlDres.add(berlDres1);
        berlDres.add(berlDres1);
        berlDres.add(berlDres1);
        berlDres.add(berlDres1);
        map.put("BERLIN_DRESDEN", berlDres);

        //hannover Magdesburg
        ArrayList<CreateTrainSquares> hannMagd = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hannMagd1 = 
            new CreateTrainSquares
            (302, 336, 323, 356, 316, 363, 297, 343);
        CreateTrainSquares hannMagd2 = 
            new CreateTrainSquares
            (328, 356, 355, 366, 352, 376, 326, 367);
        CreateTrainSquares hannMagd3 = 
            new CreateTrainSquares
            (357, 368, 387, 369, 389, 376, 358, 375 );
        CreateTrainSquares hannMagd4 = 
            new CreateTrainSquares
            (391, 370, 421, 360, 424, 368, 395, 377);
        hannMagd.add(hannMagd1);
        hannMagd.add(hannMagd2);
        hannMagd.add(hannMagd3);
        hannMagd.add(hannMagd4);
        map.put("HANNOVER_MAGDEBURG", hannMagd);

        //hannover munster 
        ArrayList<CreateTrainSquares> hannMuns = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hannMuns1 = 
            new CreateTrainSquares
            (230, 337, 259, 332, 260, 342, 230, 347);
        CreateTrainSquares hannMuns2 = 
            new CreateTrainSquares
            (197, 350, 225, 339, 229, 346 , 201, 359);
        CreateTrainSquares hannMuns3 = 
            new CreateTrainSquares
            (168, 365, 193, 352, 199, 361, 171, 372);
        CreateTrainSquares hannMuns4 = 
            new CreateTrainSquares
            (134, 360, 164, 367, 163, 373, 131, 367);
        hannMuns.add(hannMuns1);
        hannMuns.add(hannMuns2);
        hannMuns.add(hannMuns3);
        hannMuns.add(hannMuns4);
        map.put("HANNOVER_MUNSTER", hannMuns);

        //hannover kassel left
        ArrayList<CreateTrainSquares> hannKass = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hannKass1 = 
            new CreateTrainSquares
            (244, 348, 255, 348, 251, 379, 241, 377);
        CreateTrainSquares hannKass2 = 
            new CreateTrainSquares
            (240, 384, 250, 383, 250, 412, 242, 414 );
        CreateTrainSquares hannKass3 = 
            new CreateTrainSquares
            (240, 416, 249, 414, 256, 446, 245, 446);
        hannKass.add(hannKass1);
        hannKass.add(hannKass2);
        hannKass.add(hannKass3);
         CreateTrainSquares hannKass1r = 
            new CreateTrainSquares
            (258, 349, 269, 350, 264, 379, 255, 379);
        CreateTrainSquares hannKass2r = 
            new CreateTrainSquares
            (254, 384, 263, 383,263, 414,254, 413);
        CreateTrainSquares hannKass3r = 
            new CreateTrainSquares
            (255, 419, 263, 417, 268, 443, 259, 446);
        hannKass.add(hannKass1r);
        hannKass.add(hannKass2r);
        hannKass.add(hannKass3r);
        map.put("HANNOVER_KASSEL", hannKass);

        //hannover kassel right
        // ArrayList<CreateTrainSquares> hannKassr = 
            // new ArrayList<CreateTrainSquares>();
       
        // map.put("HANNOVER_KASSEL", hannKassr);

        //hannover erfurt green
        ArrayList<CreateTrainSquares> hannErfu = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares hannErfu1 =
            new CreateTrainSquares
            (283, 347, 292, 342, 307, 366, 297, 373);
        CreateTrainSquares hannErfu2 = 
            new CreateTrainSquares
            (302, 375, 309, 369, 325, 396, 316, 401);
        CreateTrainSquares hannErfu3 = 
            new CreateTrainSquares
            (316, 404, 325, 397,341, 423, 333, 429);
        CreateTrainSquares hannErfu4 = 
            new CreateTrainSquares
            (335, 433, 343, 428,359, 454, 350, 460);
        CreateTrainSquares hannErfu5 = 
            new CreateTrainSquares
            (352, 463, 359, 458, 375, 479, 366, 488);
        hannErfu.add(hannErfu1);
        hannErfu.add(hannErfu2);
        hannErfu.add(hannErfu3);
        hannErfu.add(hannErfu4);
        hannErfu.add(hannErfu5);
       CreateTrainSquares hannErfu1o = 
        new CreateTrainSquares
        (271, 354, 279, 350, 295, 374, 287, 380 );
        CreateTrainSquares hannErfu2o = 
            new CreateTrainSquares
            (288, 382, 296, 377, 313, 404, 303, 408);
        CreateTrainSquares hannErfu3o = 
            new CreateTrainSquares
            (306, 411, 314, 404, 330,  430, 321, 435 );
        CreateTrainSquares hannErfu4o = 
            new CreateTrainSquares
            (324, 439, 333, 435, 348, 460, 337, 464);
        CreateTrainSquares hannErfu5o = 
            new CreateTrainSquares
            (339, 467, 349, 464, 365, 488, 354, 492);
        hannErfu.add(hannErfu1o);
        hannErfu.add(hannErfu2o);
        hannErfu.add(hannErfu3o);
        hannErfu.add(hannErfu4o);
        hannErfu.add(hannErfu5o);
        map.put("ERFURT_HANNOVER", hannErfu);

        //hanover erfurt orange
        // ArrayList<CreateTrainSquares> hannErfuo = 
            // new ArrayList<CreateTrainSquares>();

        //map.put("ERFURT_HANNOVER", hannErfuo);

        //munster dortmund left
        ArrayList<CreateTrainSquares> munsDort = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares munsDort1 = 
            new CreateTrainSquares
            (107, 376, 116, 377, 108, 405, 98, 402);
                       
        CreateTrainSquares munsDort1r = 
            new CreateTrainSquares
            (121, 378, 129, 380, 121, 409, 113, 408);
        munsDort.add(munsDort1r);
        munsDort.add(munsDort1);
        map.put("DORTMUND_MUNSTER", munsDort);

        //musnter dortmund right


        //madgeburg leipzig 
        ArrayList<CreateTrainSquares> magdLeip = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares magdLeip1 = 
            new CreateTrainSquares
            (435,374, 445, 371,456, 399,	447, 403);
        CreateTrainSquares magdLeip2 = 
            new CreateTrainSquares
            (449 ,407,458,401,470, 430,459, 434);
        magdLeip.add(magdLeip1);
        magdLeip.add(magdLeip2);
        map.put("LEIPZIG_MAGDEBURG", magdLeip);

        //dortmund dusseldorf top
        ArrayList<CreateTrainSquares> dortDuss = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dortDuss1 = 
            new CreateTrainSquares
            (61, 423, 88, 412, 93, 421,65, 431);
             CreateTrainSquares dortDuss1m = 
            new CreateTrainSquares
            (67, 435,94, 422, 98, 432, 69, 447);
        dortDuss.add(dortDuss1m);
        dortDuss.add(dortDuss1);
        map.put("DORTMUND_DUSSELDORF", dortDuss);

        //dortmund dusseldorf middle
        // ArrayList<CreateTrainSquares> dortDussm = 
            // new ArrayList<CreateTrainSquares>();
       
        // map.put("DORTMUND_DUSSELDORF", dortDussm);

        //dortmund dusseldorf bottom
        ArrayList<CreateTrainSquares> dortDussb = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dortDuss1b = 
            new CreateTrainSquares
            (70, 448, 98, 434, 104, 445, 72, 458);
        dortDussb.add(dortDuss1b);
        map.put("DORTMUND_DUSSELDORf", dortDussb);

        //dortmund kassel 
        ArrayList<CreateTrainSquares> dortKass = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dortKass1 = 
            new CreateTrainSquares
            (120, 431, 143, 449, 136, 457, 116, 439);
        CreateTrainSquares dortKass2 = 
            new CreateTrainSquares
            (146, 451,175, 462, 170, 470, 143, 459);
        CreateTrainSquares dortKass3 = 
            new CreateTrainSquares
            (177, 464, 209, 462, 209, 470, 177, 471);
        CreateTrainSquares dortKass4 = 
            new CreateTrainSquares
            (211, 462, 239, 453, 243, 462, 214, 471);
        dortKass.add(dortKass1);
        dortKass.add(dortKass2);
        dortKass.add(dortKass3);
        dortKass.add(dortKass4);
        map.put("DORTMUND_KASSEL", dortKass);

        //dusseldorf Koln left
        ArrayList<CreateTrainSquares> dussKoln = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dussKoln1 = 
            new CreateTrainSquares
            (32, 463, 41, 462, 44, 495,33, 495);
                    CreateTrainSquares dussKoln1m =
            new CreateTrainSquares
            (44, 464,55, 464, 55, 495, 44, 493);
        dussKoln.add(dussKoln1m);
        dussKoln.add(dussKoln1);
        map.put("DUSSELDORF_KOLN", dussKoln);

        //dusseldorf Koln middle


        //dusseldirf koln right
        ArrayList<CreateTrainSquares> dussKolnr = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dussKoln1r = 
            new CreateTrainSquares
            (58, 464,67, 462,69, 492, 59, 492);
        dussKolnr.add(dussKoln1r);
        map.put("DUSSELDORF_KOLN", dussKolnr);

        //leipzig dresden 
        ArrayList<CreateTrainSquares> leipDres = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares leipDres1 = 
            new CreateTrainSquares
            (488, 442, 517, 451, 513, 462, 485, 449);
        CreateTrainSquares leipDres2 = 
            new CreateTrainSquares
            (521, 453, 547, 463, 544, 472, 516, 463);
        CreateTrainSquares leipDres3 = 
            new CreateTrainSquares
            (552, 465, 580, 474, 576, 482, 548, 473);
        leipDres.add(leipDres1);
        leipDres.add(leipDres2);
        leipDres.add(leipDres3);
        map.put("DRESDEN_LEIPZIG",leipDres);

        //leipzig chemnitz
        ArrayList<CreateTrainSquares> leipChem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares leipChem1 = 
            new CreateTrainSquares
            (475, 460, 483, 452, 502, 472, 497, 482);
        CreateTrainSquares leipChem2 = 
            new CreateTrainSquares
            (498, 483, 504, 475, 526, 496, 520, 503);
        leipChem.add(leipChem1);
        leipChem.add(leipChem2);
        map.put("CHEMNITZ_LEIPZIG",leipChem);

        //liepzig erfut
        ArrayList<CreateTrainSquares> leipErfu = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares leipErfu1 = 
            new CreateTrainSquares
            (460, 439, 459, 445, 429, 444, 429, 434);
        CreateTrainSquares leipErfu2 = 
            new CreateTrainSquares
            (421, 439, 425, 444, 399, 460, 394, 452);
        CreateTrainSquares leipErfu3 = 
            new CreateTrainSquares
            (390, 460, 397, 461, 387, 489, 378, 488);
        leipErfu.add(leipErfu1);
        leipErfu.add(leipErfu2);
        leipErfu.add(leipErfu3);
        map.put("ERFURT_LEIPZIG", leipErfu);

        //kassel erfut
        ArrayList<CreateTrainSquares> kassErfu =
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kassErfu1 = 
            new CreateTrainSquares
            (278, 467, 293, 491, 285, 499, 270, 473);
        CreateTrainSquares kassErfu2 = 
            new CreateTrainSquares
            (296, 495, 325, 507, 318, 514, 291, 503 );
        CreateTrainSquares kassErfu3 = 
            new CreateTrainSquares
            (325, 509, 356, 499, 358, 509, 330, 516);
        kassErfu.add(kassErfu1);
        kassErfu.add(kassErfu2);
        kassErfu.add(kassErfu3);
        map.put("ERFURT_KASSEL", kassErfu);

        //kassel frankfurt blue
        ArrayList<CreateTrainSquares> kassFrank = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kassFrank1 =
            new CreateTrainSquares
            (240, 467,    254, 467, 254, 498, 244, 498);
        CreateTrainSquares kassFrank2 = 
            new CreateTrainSquares
            (243, 501,    251, 503, 246, 531, 238, 531);
        CreateTrainSquares kassFrank3 = 
            new CreateTrainSquares
            (234, 532,    242, 540, 225, 561, 217, 557);
        CreateTrainSquares kassFrank4 = 
            new CreateTrainSquares
            (214, 557, 219, 565,193, 582, 190, 575);
        kassFrank.add(kassFrank1);
        kassFrank.add(kassFrank2);
        kassFrank.add(kassFrank3);
        kassFrank.add(kassFrank4);
        CreateTrainSquares kassFrank1w = 
            new CreateTrainSquares
            (256, 477, 264, 477, 265, 505, 255, 507);
        CreateTrainSquares kassFrank2w = 
            new CreateTrainSquares
            (254, 508,     266, 513, 258, 540, 247, 537);
        CreateTrainSquares kassFrank3w = 
            new CreateTrainSquares
            (246, 541,    254, 548, 236, 571, 228, 566);
        CreateTrainSquares kassFrank4w = 
            new CreateTrainSquares
            (225, 568,    232, 574, 206, 590, 200, 583);
        kassFrank.add(kassFrank1w);
        kassFrank.add(kassFrank2w);
        kassFrank.add(kassFrank3w);
        kassFrank.add(kassFrank4w);
        map.put("FRANKFURT_KASSEL", kassFrank);

        //kassel franfurt white



        //koln koblenz left
        ArrayList<CreateTrainSquares> kolnKobl = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kolnKobl1 = 
            new CreateTrainSquares
            (37, 534, 48, 533, 57, 560,44, 564);
                    CreateTrainSquares kolnKobl1r = 
            new CreateTrainSquares
            (49, 530,59, 527, 67, 557, 56, 558);
        kolnKobl.add(kolnKobl1r);
        kolnKobl.add(kolnKobl1);
        map.put("KOBLENZ_KOLN", kolnKobl);

        //koln koblenz right


        //koln frankfurt top
        ArrayList<CreateTrainSquares> kolnFran =
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares kolnFran1 =
            new CreateTrainSquares
            (74, 502, 100, 520,94, 526,68, 511);
        CreateTrainSquares kolnFran2 = 
            new CreateTrainSquares
            (102, 520,128, 536,124,542,97, 528 );
        CreateTrainSquares kolnFran3 = 
            new CreateTrainSquares
            (97, 528,158,553, 150, 561, 126, 546);
        CreateTrainSquares kolnFran4 = 
            new CreateTrainSquares
            (160, 553,184, 569,182,575,155, 564);
            
                    CreateTrainSquares kolnFran1b = 
            new CreateTrainSquares
            (68, 514,94, 531, 88, 535, 61, 521);
        CreateTrainSquares kolnFran2b = 
            new CreateTrainSquares
            (97, 531,121, 546, 115, 554, 90, 538);
        CreateTrainSquares kolnFran3b = 
            new CreateTrainSquares
            (125, 549, 151, 565, 145, 570, 121, 557);
        CreateTrainSquares kolnFran4b = 
            new CreateTrainSquares
            (152, 565, 178, 580, 174, 586, 149, 573);
        kolnFran.add(kolnFran1b);
        kolnFran.add(kolnFran2b);
        kolnFran.add(kolnFran3b);
        kolnFran.add(kolnFran4b);
        kolnFran.add(kolnFran1);
        kolnFran.add(kolnFran2);
        kolnFran.add(kolnFran3);
        kolnFran.add(kolnFran4);
        map.put("FRANKFURT_KOLN",kolnFran);

        //koln frankfurt bottom


        //erfurt nurnburg yellow
        ArrayList<CreateTrainSquares> erfuNurn = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares erfuNurn1 = 
            new CreateTrainSquares
            (358, 511, 370, 511,372, 542,359, 541);
        CreateTrainSquares erfuNurn2 = 
            new CreateTrainSquares
            (360, 546, 371, 545, 371, 577, 360, 577);
        CreateTrainSquares erfuNurn3 = 
            new CreateTrainSquares
            (360, 580, 371, 581, 373, 610, 361, 608);
            //608
        CreateTrainSquares erfuNurn4 =
            new CreateTrainSquares
            (361, 613, 372, 613, 374, 641, 364, 642);
             CreateTrainSquares erfuNurn1p = 
            new CreateTrainSquares
            (373, 515, 383, 512, 384, 544, 375, 544);
        CreateTrainSquares erfuNurn2p = 
            new CreateTrainSquares
            (374, 548, 384, 547, 384, 573, 375, 577);
        CreateTrainSquares erfuNurn3p = 
            new CreateTrainSquares
            (374, 582, 383, 581, 384, 608, 374,610);
        CreateTrainSquares erfuNurn4p = 
            new CreateTrainSquares
            (374, 613, 384, 614, 385, 642, 375, 641);
        erfuNurn.add(erfuNurn1p);
        erfuNurn.add(erfuNurn2p);
        erfuNurn.add(erfuNurn3p);
        erfuNurn.add(erfuNurn4p);
        erfuNurn.add(erfuNurn1);
        erfuNurn.add(erfuNurn2);
        erfuNurn.add(erfuNurn3);
        erfuNurn.add(erfuNurn4);
        map.put("ERFURT_NURNBERG", erfuNurn);

        //erfurt nurnburg purple 

       
       // map.put("ERFURT_NURNBERG", erfuNurnp);

        //erfurt chemnitz
        ArrayList<CreateTrainSquares> erfuChem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares erfuChem1 = 
            new CreateTrainSquares
            (388, 496, 418, 498, 417, 507, 388, 505);
        CreateTrainSquares erfuChem2 = 
            new CreateTrainSquares
            (420, 497, 451, 502, 450, 511, 420, 507);
        CreateTrainSquares erfuChem3 = 
            new CreateTrainSquares
            (455, 501, 484, 503, 486, 511, 454, 510);
        CreateTrainSquares erfuChem4 = 
            new CreateTrainSquares
            (487, 504, 516, 506, 515, 515, 489, 514);
        erfuChem.add(erfuChem1);
        erfuChem.add(erfuChem2);
        erfuChem.add(erfuChem3);
        erfuChem.add(erfuChem4);
        map.put("CHEMNITZ_ERFURT", erfuChem);

        //erfurt regensburg white
        ArrayList<CreateTrainSquares> erfuRege = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares erfuRege1 = 
            new CreateTrainSquares
            (387, 519, 393, 512, 419, 526, 414, 536);
        CreateTrainSquares erfuRege2 = 
            new CreateTrainSquares
            (415, 536, 423,530, 446, 551, 438, 558);
        CreateTrainSquares erfuRege3 = 
            new CreateTrainSquares
            (439, 559, 448, 555, 465, 579, 458, 584);
        CreateTrainSquares erfuRege4 = 
            new CreateTrainSquares
            (457, 587, 469, 583, 481, 610, 472, 613);
        CreateTrainSquares erfuRege5 = 
            new CreateTrainSquares
            (474, 616, 481, 613, 489, 643, 479, 647);
        CreateTrainSquares erfuRege6 = 
            new CreateTrainSquares
            (480, 650, 490, 648, 490, 679, 481, 678);
        CreateTrainSquares erfuRege7 = 
            new CreateTrainSquares
            (480, 681, 490, 681, 490, 714, 479, 713);
        erfuRege.add(erfuRege1);
        erfuRege.add(erfuRege2);
        erfuRege.add(erfuRege3);
        erfuRege.add(erfuRege4);
        erfuRege.add(erfuRege5);
        erfuRege.add(erfuRege6);
        erfuRege.add(erfuRege7);
        map.put("ERFURT_REGENSBURG", erfuRege);

        //dresden regensburg
        ArrayList<CreateTrainSquares> dresRege = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dresRege1 = 
            new CreateTrainSquares
            (579, 500, 589, 501, 582, 528, 574, 527 );
        CreateTrainSquares dresRege2 = 
            new CreateTrainSquares
            (571, 534, 582, 534, 574, 561, 565, 561);
        CreateTrainSquares dresRege3 =
            new CreateTrainSquares
            (564, 564, 572, 565, 567, 593,557, 593);
        CreateTrainSquares dresRege4 = 
            new CreateTrainSquares
            (556, 598,     564, 599, 559, 628, 551, 624);
        CreateTrainSquares dresRege5 = 
            new CreateTrainSquares
            (550, 627, 557, 629, 548, 660, 539, 656);
        CreateTrainSquares dresRege6 = 
            new CreateTrainSquares
            (538, 659, 545, 662, 533, 690, 526, 687);
        CreateTrainSquares dresRege7 = 
            new CreateTrainSquares
            (523, 689, 531, 693, 516, 718, 508, 715);
        dresRege.add(dresRege1);
        dresRege.add(dresRege2);
        dresRege.add(dresRege3);
        dresRege.add(dresRege4);
        dresRege.add(dresRege5);
        dresRege.add(dresRege6);
        dresRege.add(dresRege7);
        map.put("DRESDEN_REGENSBURG", dresRege);

        //dresden chemnitz
        ArrayList<CreateTrainSquares> dresChem = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares dresChem1 = 
            new CreateTrainSquares
            (541, 498,570, 487, 574, 494, 548, 509);
        dresChem.add(dresChem1);
        map.put("CHEMNITZ_DRESDEN", dresChem);

        //chemnitz regensburg
        ArrayList<CreateTrainSquares> chemRege = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares chemRege1 = 
            new CreateTrainSquares
            (520, 519, 527, 526, 506, 547, 500, 537);
        CreateTrainSquares chemRege2 = 
            new CreateTrainSquares
            (494, 548, 504, 548, 503, 579, 494, 579);
        CreateTrainSquares chemRege3 = 
            new CreateTrainSquares
            (494, 582, 503, 583, 502, 611, 494, 611);
        CreateTrainSquares chemRege4 = 
            new CreateTrainSquares
            (493, 616,504, 613, 503, 645, 495, 646);
        CreateTrainSquares chemRege5 = 
            new CreateTrainSquares
            (494, 651, 504, 649, 504, 678, 495, 679);
        CreateTrainSquares chemRege6 =
            new CreateTrainSquares
            (495, 681, 502, 682,503, 710, 494, 712);
        chemRege.add(chemRege1);
        chemRege.add(chemRege2);
        chemRege.add(chemRege3);
        chemRege.add(chemRege4);
        chemRege.add(chemRege5);
        chemRege.add(chemRege6);
        map.put("CHEMNITZ_REGENSBURG", chemRege);

        //koblenz mainz top
        ArrayList<CreateTrainSquares> koblMain = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares koblMain1 = 
            new CreateTrainSquares
            (77, 583,82,573, 107, 590, 103, 601);
        CreateTrainSquares koblMain2 = 
            new CreateTrainSquares
            (104, 601, 110, 594, 134, 611, 129, 619);
                    CreateTrainSquares koblMain1b = 
            new CreateTrainSquares
            (68, 596, 76, 587, 99, 601,94, 610);
        CreateTrainSquares koblMain2b = 
            new CreateTrainSquares
            (97, 612,101, 605, 125, 623, 120, 628);
        koblMain.add(koblMain1b);
        koblMain.add(koblMain2b);
        koblMain.add(koblMain1);
        koblMain.add(koblMain2);
        map.put("KOBLENZ_MAINZ", koblMain);

        //koblenz mainz bottom


        //frankfurt mainz top
        ArrayList<CreateTrainSquares> franMain = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares franMain1 = 
            new CreateTrainSquares
            (144, 611, 170, 593, 175, 600, 150, 617);
                    CreateTrainSquares franMain1b = 
            new CreateTrainSquares
            (153, 620,178, 603,183, 610,160, 627);
        franMain.add(franMain1b);
        franMain.add(franMain1);
        map.put("FRANKFURT_MAINZ", franMain);

        //frankfurt mainz bottom 


        //frankfurt wurzburg top
        ArrayList<CreateTrainSquares> franWurz = 
            new ArrayList<CreateTrainSquares>();
        CreateTrainSquares franWurz1 = 
            new CreateTrainSquares
            (216, 588, 244, 601, 240, 610, 212, 599);
        CreateTrainSquares franWurz2 = 
            new CreateTrainSquares
            (247, 603, 274, 613, 270, 621, 243, 612);
        franWurz.add(franWurz1);
        franWurz.add(franWurz2);
                CreateTrainSquares franWurz1b = 
        new CreateTrainSquares
        (211, 603, 238, 613, 235, 620, 208, 612);
        CreateTrainSquares franWurz2b = 
        new CreateTrainSquares
        (241, 613, 269, 624, 267, 632, 238, 623);
        franWurz.add(franWurz1b);
        franWurz.add(franWurz2b);
        map.put("FRANKFURT_WURZBURG", franWurz);


        //frankfurt mannheim left
        ArrayList<CreateTrainSquares> franMann = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares franMann1 = 
        new CreateTrainSquares
        (186, 609, 197, 614, 189, 642, 181, 639);
        CreateTrainSquares franMann2 = 
        new CreateTrainSquares
        (180, 643, 189, 645, 183, 673, 174, 673);
        franMann.add(franMann1);
        franMann.add(franMann2);
         CreateTrainSquares franMann1r = 
        new CreateTrainSquares
        (201,613,210, 616, 203, 645, 194, 643);
        CreateTrainSquares franMann2r = 
        new CreateTrainSquares
        (193, 646, 203, 649, 195, 677, 186, 674);
        franMann.add(franMann1r);
        franMann.add(franMann2r);
        map.put("FRANKFURT_MANNHEIM", franMann);
        
        //frankfurt mannheim right

        
        //wurzburg Nurnburg top
        ArrayList<CreateTrainSquares> wurzNurn = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares wurzNurn1 = 
        new CreateTrainSquares
        (333, 634, 361, 646, 356, 656, 327, 645);
        CreateTrainSquares wurzNurn2 = 
        new CreateTrainSquares
        (326, 647, 353, 657, 352, 663, 323, 655);
           CreateTrainSquares wurzNurn1b = 
        new CreateTrainSquares
        (301, 623, 329, 635, 324, 642, 295, 632);
        CreateTrainSquares wurzNurn2b =
        new CreateTrainSquares
        (296, 636, 322, 647, 320, 655, 293, 644);
        wurzNurn.add(wurzNurn1b);
        wurzNurn.add(wurzNurn2b);
        wurzNurn.add(wurzNurn1);
        wurzNurn.add(wurzNurn2);
        map.put("NURNBERG_WURZBURG", wurzNurn);
        
        //wurzburg nurnberg bottom

        
        //mainz saarbruken
        ArrayList<CreateTrainSquares> mainSaar = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares mainSaar1 = 
        new CreateTrainSquares
        (102, 651, 127, 636, 133, 643, 107, 658);
        CreateTrainSquares mainSaar2 = 
        new CreateTrainSquares
        (76, 668, 99, 653, 105, 659, 80, 675);
        CreateTrainSquares mainSaar3 = 
        new CreateTrainSquares
        (47, 686, 71, 671, 78, 677, 53, 693);
        mainSaar.add(mainSaar1);
        mainSaar.add(mainSaar2);
        mainSaar.add(mainSaar3);
        map.put("MAINZ_SAARBRUCKEN", mainSaar);
        
        //mainz mannheim left
        ArrayList<CreateTrainSquares> mainMann =
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares mainMann1 = 
        new CreateTrainSquares
        (135, 649, 146, 645, 159, 670,147, 674);
        mainMann.add(mainMann1);
        CreateTrainSquares mainMann1r =
        new CreateTrainSquares
        (149, 643, 156, 639, 168, 665, 160, 669);
        mainMann.add(mainMann1r);
        map.put("MAINZ_MANNHEIM", mainMann);
        
      
        
        //nurnberg regensburg
        ArrayList<CreateTrainSquares> nurnRege = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares nurnRege1 = 
        new CreateTrainSquares
        (397, 647, 424, 668, 418, 675, 392, 657);
        CreateTrainSquares nurnRege2 = 
        new CreateTrainSquares
        (426, 670, 449, 684, 444, 693, 420, 676);
        CreateTrainSquares nurnRege3 = 
        new CreateTrainSquares
        (453, 687, 477, 703, 472, 712, 447, 696);
        nurnRege.add(nurnRege1);
        nurnRege.add(nurnRege2);
        nurnRege.add(nurnRege3);
        map.put("NURNBERG_REGENSBURG",nurnRege);
        
        //nurnberg munchen blue
        ArrayList<CreateTrainSquares> nurnMunc = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares nurnMunc1 = 
        new CreateTrainSquares
        (372, 673, 383, 669, 394, 695, 384, 699);
        CreateTrainSquares nurnMunc2 = 
        new CreateTrainSquares
        (387, 705, 396, 701, 405, 725, 397, 731);
        CreateTrainSquares nurnMunc3 =
        new CreateTrainSquares
        (398, 737, 409, 732, 420, 758, 411, 760);
        CreateTrainSquares nurnMunc4 = 
        new CreateTrainSquares
        (414, 764,421, 760, 432, 785, 422, 790);
        CreateTrainSquares nurnMunc5 = 
        new CreateTrainSquares
        (426, 796, 435, 792, 445, 817, 437, 822);
        nurnMunc.add(nurnMunc1);
        nurnMunc.add(nurnMunc2);
        nurnMunc.add(nurnMunc3);
        nurnMunc.add(nurnMunc4);
        nurnMunc.add(nurnMunc5);
                CreateTrainSquares nurnMunc1b =
        new CreateTrainSquares
        (384, 668, 392, 664, 405, 688, 396, 693);
        CreateTrainSquares nurnMunc2b = 
        new CreateTrainSquares
        (397, 697, 407, 694, 419, 721, 409, 724);
        CreateTrainSquares nurnMunc3b = 
        new CreateTrainSquares
        (412, 728, 420, 724,431, 750, 424, 756);
        CreateTrainSquares nurnMunc4b = 
        new CreateTrainSquares
        (424, 758, 432, 754, 446, 782, 435, 787);
        CreateTrainSquares nurnMunc5b =
        new CreateTrainSquares
        (438, 789, 447, 785, 459, 813, 449, 817);
        nurnMunc.add(nurnMunc1b);
        nurnMunc.add(nurnMunc2b);
        nurnMunc.add(nurnMunc3b);
        nurnMunc.add(nurnMunc4b);
        nurnMunc.add(nurnMunc5b);
        map.put("MUNCHEN_NURNBERG", nurnMunc);
        
        //nurnberg munchen black

        
        //nurnberg augsburg
        ArrayList<CreateTrainSquares> nurnAugs = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares nurnAugs1 =
        new CreateTrainSquares
        (356, 667, 367, 668, 366, 699, 355, 697); 
        CreateTrainSquares nurnAugs2 = 
        new CreateTrainSquares
        (355, 702, 365, 699, 365,  732, 354, 731); 
        CreateTrainSquares nurnAugs3 = 
        new CreateTrainSquares
        (354, 733, 363, 733, 364, 764, 352, 765); 
        CreateTrainSquares nurnAugs4 = 
        new CreateTrainSquares
        (353, 767, 362, 767, 361, 796, 351, 797); 
        nurnAugs.add(nurnAugs1);
        nurnAugs.add(nurnAugs2);
        nurnAugs.add(nurnAugs3);
        nurnAugs.add(nurnAugs4);
        map.put("AUGSBURG_NURNBERG", nurnAugs);
        
        //mannheim saarbrucken
        ArrayList<CreateTrainSquares> mannSaar = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares mannSaar1 = 
        new CreateTrainSquares
        (121, 688, 152, 684, 154, 693, 122, 699); 
        CreateTrainSquares mannSaar2 = 
        new CreateTrainSquares
        (89, 692,  118, 689, 119, 697, 90, 702); 
        CreateTrainSquares mannSaar3 = 
        new CreateTrainSquares
        (55, 697,  86, 693,88, 702,56, 705); 
        mannSaar.add(mannSaar1);
        mannSaar.add(mannSaar2);
        mannSaar.add(mannSaar3);
        map.put("MANNHEIM_SAARBRUCKEN", mannSaar);
        
        // koblenz to saarbruken
         ArrayList<CreateTrainSquares> koblSaar = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares koblSaar1 = 
        new CreateTrainSquares
        (51, 587, 63, 589, 56, 619, 45, 618); 
        CreateTrainSquares koblSaar2 = 
        new CreateTrainSquares
        (46, 621, 55, 622, 49, 652, 40, 649); 
        CreateTrainSquares koblSaar3 = 
        new CreateTrainSquares
        (39, 655, 48, 654, 43, 685, 34, 681); 
        koblSaar.add(koblSaar1);
        koblSaar.add(koblSaar2);
        koblSaar.add(koblSaar3);
        map.put("KOBLENZ_SAARBRUCKEN", koblSaar);
        
        
        //mannheim karlsruhe
        ArrayList<CreateTrainSquares> mannKarl = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares mannKarl1 = 
        new CreateTrainSquares
        (158, 701, 167, 700, 167, 730, 157, 730); 
        mannKarl.add(mannKarl1);
        map.put("KARLSRUHE_MANNHEIM", mannKarl);
        
        //mannheim stuttgart left
        ArrayList<CreateTrainSquares> mannStut = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares mannStut1 = 
        new CreateTrainSquares
        (185, 692, 191, 688, 209, 712, 202, 717); 
        CreateTrainSquares mannStut2 = 
        new CreateTrainSquares
        (173, 701, 180, 695, 197, 718, 190, 727); 
                CreateTrainSquares mannStut1r = 
        new CreateTrainSquares
        (201, 719, 211, 713, 228, 736, 220, 742); 
        CreateTrainSquares mannStut2r = 
        new CreateTrainSquares
        (190, 728, 199, 720, 218, 744, 210 ,749); 
        mannStut.add(mannStut1r);
        mannStut.add(mannStut2r);
        mannStut.add(mannStut1);
        mannStut.add(mannStut2);
        map.put("MANNHEIM_STUTTGART", mannStut);
        
        //mannheim stuttgart right

        //saarbrucken karlsruhe
        ArrayList<CreateTrainSquares> saarKarl = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares saarKarl1 = 
        new CreateTrainSquares
        (56, 710, 76, 730, 70, 736,48, 714);
        CreateTrainSquares saarKarl2 = 
        new CreateTrainSquares
        (78, 733, 109, 735,107, 747,77, 742);
        CreateTrainSquares saarKarl3 = 
        new CreateTrainSquares
        (109, 736, 141, 734, 141, 742, 113, 746);
        saarKarl.add(saarKarl1);
        saarKarl.add(saarKarl2);
        saarKarl.add(saarKarl3);
        map.put("KARLSRUHE_SAARBRUCKEN", saarKarl);
        
        //saarbrucken frankreich 
        ArrayList<CreateTrainSquares> saarFran = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares saarFran1 = 
        new CreateTrainSquares
        (31, 712,38, 712, 33, 744, 26, 742);
        saarFran.add(saarFran1);
        map.put("FRANKREICH_SAARBRUCKEN", saarFran);
        
        //regensburg osterreich 
        ArrayList<CreateTrainSquares> regeOste = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares regeOste1 = 
        new CreateTrainSquares
        (505, 734, 513, 730, 532, 754, 524, 759);
        CreateTrainSquares regeOste2 = 
        new CreateTrainSquares
        (524, 763, 533, 757, 550, 781, 542, 788);
        CreateTrainSquares regeOste3 = 
        new CreateTrainSquares
        (543, 790, 551, 784, 569, 809, 560, 815);
        CreateTrainSquares regeOste4 = 
        new CreateTrainSquares
        (561, 819, 569, 815, 586, 838, 579, 841);
        regeOste.add(regeOste1);
        regeOste.add(regeOste2);
        regeOste.add(regeOste3);
        regeOste.add(regeOste4);
        map.put("OSTERREICHEAST_REGENSBURG", regeOste);
        
        //regensburg munchen
        ArrayList<CreateTrainSquares> regeMunc = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares regeMunc1 = 
        new CreateTrainSquares
        (494, 744, 503, 742, 512, 771, 502, 771);
        CreateTrainSquares regeMunc2 = 
        new CreateTrainSquares
        (501, 778, 511, 781,497, 806, 488, 803);
        CreateTrainSquares regeMunc3 = 
        new CreateTrainSquares
        (486, 804, 491, 815, 463, 828, 459, 821);
        regeMunc.add(regeMunc1);
        regeMunc.add(regeMunc2);
        regeMunc.add(regeMunc3);
        map.put("MUNCHEN_REGENSBURG",regeMunc);
        
        //karlsruhe stuttgart
        ArrayList<CreateTrainSquares> karlStut = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares karlStut1 = 
        new CreateTrainSquares
        (177, 745, 209, 754, 205, 762, 175, 755);
        karlStut.add(karlStut1);
        map.put("KARLSRUHE_STUTTGART", karlStut);
        
        //karlsruhe frankreich
        ArrayList<CreateTrainSquares> karlFran = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares karlFran1 = 
        new CreateTrainSquares
        (117, 761, 144, 746, 147, 757, 121, 770);
        CreateTrainSquares karlFran2 = 
        new CreateTrainSquares
        (88, 778,  113, 763, 118, 771, 91, 784 );
        karlFran.add(karlFran1);
        karlFran.add(karlFran2);
        map.put("FRANKREICH_KARLSRUHE", karlFran);
        
        //karlsruhe freiburg
        ArrayList<CreateTrainSquares> karlFrei = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares karlFrei1 = 
        new CreateTrainSquares
        (155, 756, 166, 757, 156, 790, 147, 785);
        CreateTrainSquares karlFrei2 = 
        new CreateTrainSquares
        (146, 789, 154, 790, 144, 819, 136, 819);
        CreateTrainSquares karlFrei3 = 
        new CreateTrainSquares
        (136, 820, 145, 822, 136, 851, 125, 847);
        karlFrei.add(karlFrei1);
        karlFrei.add(karlFrei2);
        karlFrei.add(karlFrei3);
        map.put("FREIBURG_KARLSRUHE", karlFrei);
        
        //stuttgrat freiburg
        ArrayList<CreateTrainSquares> stutFrei = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares stutFrei1 = 
        new CreateTrainSquares
        (186, 796, 204, 772, 213, 779,193, 799);
        CreateTrainSquares stutFrei2 =
        new CreateTrainSquares
        (164, 821, 184, 796, 189, 804, 172, 825);
        CreateTrainSquares stutFrei3 = 
        new CreateTrainSquares
        (141, 845, 161, 823, 169, 828, 150, 850);
        stutFrei.add(stutFrei1);
        stutFrei.add(stutFrei2);
        stutFrei.add(stutFrei3);
        map.put("FREIBURG_STUTTGART", stutFrei);
        
        //stuttgart konstanz
        ArrayList<CreateTrainSquares> stutKons = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares stutKons1 = 
        new CreateTrainSquares
        (216, 777,226, 775,227, 805, 216, 805);
        CreateTrainSquares stutKons2 = 
        new CreateTrainSquares
        (216, 809,226, 807, 226, 836, 215, 838);
        CreateTrainSquares stutKons3 = 
        new CreateTrainSquares
        (215, 841,223, 841,  225, 871, 214, 871);
        stutKons.add(stutKons1);
        stutKons.add(stutKons2);
        stutKons.add(stutKons3);
        map.put("KONSTANZ_STUTTGART", stutKons);
        
        //stuttgart ulm bottom
        ArrayList<CreateTrainSquares> stutUlm = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares stutUlm1 = 
        new CreateTrainSquares
        (246, 753,272, 770, 265, 777, 239, 761 );
        CreateTrainSquares stutUlm2 = 
        new CreateTrainSquares
        (239, 765,262, 781, 256, 789, 233, 772);
        stutUlm.add(stutUlm1);
        stutUlm.add(stutUlm2);
                CreateTrainSquares stutUlm1t = 
        new CreateTrainSquares
        (272, 771, 297, 789,291, 797, 266, 781);
        CreateTrainSquares stutUlm2t = 
        new CreateTrainSquares
        (265, 783, 290, 800,286, 807, 260, 791);
        stutUlm.add(stutUlm1t);
        stutUlm.add(stutUlm2t);
        map.put("STUTTGART_ULM", stutUlm);
        
        //stuttgart ulm top

        
        //ulm augsburg top
        ArrayList<CreateTrainSquares> ulmAugs = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares ulmAugs1 = 
        new CreateTrainSquares
        (313, 797,345, 797, 346, 808, 314, 806);
        ulmAugs.add(ulmAugs1);
                CreateTrainSquares ulmAugs1b = 
        new CreateTrainSquares
        (315, 809, 344, 810,344,819,313, 817);
        ulmAugs.add(ulmAugs1b);
        map.put("AUGSBURG_ULM", ulmAugs);
        
        //ulm augsburg bottom

        
        //ulm lindau
        ArrayList<CreateTrainSquares> ulmLind = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares ulmLind1 = 
        new CreateTrainSquares
        (288, 825,297, 825, 289, 853, 282, 852 );
        CreateTrainSquares ulmLind2 = 
        new CreateTrainSquares
        (282, 856,290, 855, 283, 884, 272, 882);
        ulmLind.add(ulmLind1);
        ulmLind.add(ulmLind2);
        map.put("LINDAU_ULM", ulmLind);
        
        //augsburg munchen top
        ArrayList<CreateTrainSquares> augsMunc = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares augsMunc1 = 
        new CreateTrainSquares
        (372, 806,403, 815, 400, 824, 370, 815);
        CreateTrainSquares augsMunc2 = 
        new CreateTrainSquares
        (369, 818,399, 828, 397, 837, 366, 829);
        augsMunc.add(augsMunc1);
        augsMunc.add(augsMunc2);
                CreateTrainSquares augsMunc1b = 
        new CreateTrainSquares
        (406, 815, 435, 823, 432, 833, 401, 825);
        CreateTrainSquares augsMunc2b = 
        new CreateTrainSquares
        (403, 829,430, 836, 430, 842, 400, 837);
        augsMunc.add(augsMunc1b);
        augsMunc.add(augsMunc2b);
        map.put("AUGSBURG_MUNCHEN",augsMunc);
        
        //augsbug munchen bottom

        
        //munchen osterreich 
        ArrayList<CreateTrainSquares> muncOste = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares muncOste1 = 
        new CreateTrainSquares
        (456, 849,464,840,486, 863, 479, 869);
        CreateTrainSquares muncOste2 = 
        new CreateTrainSquares
        (481, 872,490, 863, 511, 883, 505, 892);
        CreateTrainSquares muncOste3 = 
        new CreateTrainSquares
        (505, 892,509, 884, 535, 908, 528, 915);
        muncOste.add(muncOste1);
        muncOste.add(muncOste2);
        muncOste.add(muncOste3);
        map.put("MUNCHEN_OSTERREICHEAST", muncOste);
        
        //munchen lindau
        ArrayList<CreateTrainSquares> muncLind = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares muncLind1 = 
        new CreateTrainSquares
        (421, 863,446, 848, 449, 854, 423, 869);
        CreateTrainSquares muncLind2 = 
        new CreateTrainSquares
        (389, 877, 418, 865, 421, 872, 391, 884);
        CreateTrainSquares muncLind3 = 
        new CreateTrainSquares
        (357, 886,387, 877, 389, 886, 359, 892);
        CreateTrainSquares muncLind4 =
        new CreateTrainSquares
        (324, 887,355, 886, 356, 892, 325, 898);
        CreateTrainSquares muncLind5 = 
        new CreateTrainSquares
        (290, 885,321, 886, 321, 895, 292, 893);
        muncLind.add(muncLind1);
        muncLind.add(muncLind2);
        muncLind.add(muncLind3);
        muncLind.add(muncLind4);
        muncLind.add(muncLind5);
        map.put("LINDAU_MUNCHEN", muncLind);
        
        //frankreich freiburg
        ArrayList<CreateTrainSquares> franFrei = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares franFrei1 = 
        new CreateTrainSquares
        (52, 838,82, 848, 79, 853,50, 849);
        CreateTrainSquares franFrei2 = 
        new CreateTrainSquares
        (84, 845, 114, 854,112, 860, 81, 854);
        franFrei.add(franFrei1);
        franFrei.add(franFrei2);
        map.put("FRANKREICH_FREIBURG",franFrei);

        //freiburg shweiz
        ArrayList<CreateTrainSquares> freiSchw = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares freiSchw1 = 
        new CreateTrainSquares
        (112, 875,120, 879, 103, 905, 95, 900);
        CreateTrainSquares freiSchw2 = 
        new CreateTrainSquares
        (98, 916,103, 909, 125, 928, 120, 935);
        freiSchw.add(freiSchw1);
        freiSchw.add(freiSchw2);
        map.put("FREIBURG_SCHWEIZ",freiSchw);
        
        //freiburg konstanz
        ArrayList<CreateTrainSquares> freiKons = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares freiKons1 = 
        new CreateTrainSquares
        (143, 861,173, 866, 171, 878, 141, 869);
        CreateTrainSquares freiKons2 = 
        new CreateTrainSquares
        (177, 869,205, 874, 201, 883, 174, 877);
        freiKons.add(freiKons1);
        freiKons.add(freiKons2);
        map.put("FREIBURG_KONSTANZ",freiKons);
        
        //konstanz schweiz
        ArrayList<CreateTrainSquares> konsSchw = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares konsSchw1 = 
        new CreateTrainSquares
        (180, 909,205, 889, 213, 897, 185, 916);
        konsSchw.add(konsSchw1);
        map.put("KONSTANZ_SCHWEIZ",konsSchw);
        
        //konstanz lindau
        ArrayList<CreateTrainSquares> konsLind = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares konsLind1 = 
        new CreateTrainSquares
        (235, 880,264, 890, 262, 897, 231, 890);
        konsLind.add(konsLind1);
        map.put("KONSTANZ_LINDAU", konsLind);
        
        //lindau Schweiz
        ArrayList<CreateTrainSquares> lindSchw = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares lindSchw1 = 
        new CreateTrainSquares
        (245, 928,265, 907,270, 911, 250, 935);
        CreateTrainSquares lindSchw2 = 
        new CreateTrainSquares
        (209, 931,241, 930, 241, 938, 211, 939 );
        lindSchw.add(lindSchw1);
        lindSchw.add(lindSchw2);
        map.put("LINDAU_SCHWEIZ", lindSchw);
        
        //lindau osterreich
        ArrayList<CreateTrainSquares> lindOste = 
        new ArrayList<CreateTrainSquares>();
        CreateTrainSquares lindOste1 = 
        new CreateTrainSquares
        (292, 899,321, 909, 317, 919,287, 907);
        CreateTrainSquares lindOste2 = 
        new CreateTrainSquares
        (323, 911, 350, 918, 348, 927, 320, 917);
        lindOste.add(lindOste1);
        lindOste.add(lindOste2);
        map.put("LINDAU_OSTERREICHWEST",lindOste);
    }
    /**
     * Gets the hashmap of the trainsquares
     * @return HashMap the hash map of the train squares
     */
    public HashMap<String, ArrayList<CreateTrainSquares>>
    getMap(){
        return map;
    }
}

