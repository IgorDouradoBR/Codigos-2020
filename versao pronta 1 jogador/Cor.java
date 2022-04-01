public enum Cor {
    VERMELHO("-fx-background-color: red;-fx-text-fill: white;-fx-border-color: black;"), 
    VERDE("-fx-background-color: green;-fx-text-fill: white;-fx-border-color: black;"),  
    AMARELO("-fx-background-color: yellow;-fx-text-fill: black;-fx-border-color: black;"),
    AZUL("-fx-background-color: blue;-fx-text-fill: white;-fx-border-color: black;"),
    ROXO("-fx-background-color: purple;-fx-text-fill: white;-fx-border-color: black;"), 
    LARANJA("-fx-background-color: orange;-fx-text-fill: black;-fx-border-color: black;"),
    CINZA("-fx-background-color: darkgray;-fx-text-fill: black;-fx-border-color: white;"),
    MARROM("-fx-background-color: maroon;-fx-text-fill: black;-fx-border-color: white;"),
    OLIVA("-fx-background-color: olive;-fx-text-fill: black;-fx-border-color: white;"),
    ROSA("-fx-background-color: pink;-fx-text-fill: black;-fx-border-color: white;"),    
    PRETO("-fx-background-color: black;-fx-text-fill: white;-fx-border-color: black;"),
    BRANCO("-fx-background-color: white;-fx-text-fill: black;-fx-border-color: black;");
    
    private String style;
    
    public String getStyle(){
        return style;
    }

    private Cor(String style){
        this.style = style;
    }   
}