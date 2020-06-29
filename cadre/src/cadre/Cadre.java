/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cadre;

/**
 *
 * @author stagjava
 */
public class Cadre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        char deb1 = '\u250c';
        char ligne = '\u2500';
        char fin1 = '\u2510';
        char vert = '\u2502';
        char deb2 = '\u2514';
        char fin2 = '\u2518';
        char mil1 = '\u252c';
        char mil2 = '\u2534';
        char deb3 = '\u251c';
        char fin3 = '\u2524';
        char mil3 = '\u253c';
        char lettre = 'c';
        
        // Variables
        int iMax = 80;
        
        // 1ère ligne        
        for (int  i= 0; i <= iMax ; i++) {
            
            if (i == 0) {
                System.out.print(deb1);
            } else {
                if (i == iMax ) {
                    System.out.print(fin1);
                } else  {
                    if ( i%20 == 0 ) {
                        System.out.print(mil1);                        
                        
                    } else {
                        System.out.print(ligne);                        
                    }
                }
            }
        }
        // 2ème ligne        
        System.out.println("");
        for (int  i= 0; i <= iMax ; i++) {
            
            if (i == 0) {
                System.out.print(vert);
            } else {
                if (i == iMax ) {
                    System.out.print(vert);
                } else  {
                    if ( i%20 == 0 ) {
                        System.out.print(vert);                                                
                    } else {
                        if ( i%10 == 0) {
                            System.out.print(lettre);  
                            switch (i) {
                                case 10 : lettre = 'o';
                                break;
                                case 30 : lettre = 'o';
                                break;
                                case 50 : lettre = 'l';
                                break;
                                default : lettre = ' ';
                                        
                            }                           
                        } else {
                            System.out.print(" ");                                                    
                        }
                    }
                }
            }
        }
        
        // 3ème ligne        
        System.out.println("");
        for (int  i= 0; i <= iMax ; i++) {
            
            if (i == 0) {
                System.out.print(deb3);
            } else {
                if (i == iMax ) {
                    System.out.print(fin3);
                } else  {
                    if ( i%20 == 0 ) {
                        if (i == 20) {
                            System.out.print(mil2);                        
                            
                        } else {
                            System.out.print(mil3);                        
                            
                        }
                        
                    } else {
                        System.out.print(ligne);                        
                    }
                }
            }
        }

        // 4ème ligne        
        System.out.println("");
        for (int  i= 0; i <= iMax ; i++) {
            
            if (i == 0) {
                System.out.print(vert);
            } else {
                if (i == iMax ) {
                    System.out.print(vert);
                } else  {
                    if ( i%20 == 0  && i != 20) {
                        System.out.print(vert);                                                
                    } else {
                            
                        switch (i) {
                            case 10 :  System.out.print('\u03c0');
                            break;
                            case 12 :  System.out.print('\u00c9');
                            break;
                            case 14 :  System.out.print('\u06fb');
                            break;
                            case 16 :  System.out.print('\u2230');
                            break;
                            case 18 :  System.out.print('\u25f0');
                            break;
                            case 50 :  System.out.print('\u2656');
                            break;
                            case 70 :  System.out.print('\u265c');
                            break;
                            default : System.out.print(' ');
                        }
                    }
                }
            }
        }
        
        // 5ème ligne        
        System.out.println("");
        for (int  i= 0; i <= iMax ; i++) {
            
            if (i == 0) {
                System.out.print(deb2);
            } else {
                if (i == iMax ) {
                    System.out.print(fin2);
                } else  {
                    if ( i%20 == 0 && i != 20) {
                        System.out.print(mil2);                        
                        
                    } else {
                        System.out.print(ligne);                        
                    }
                }
            }
        }
        
    }

}
