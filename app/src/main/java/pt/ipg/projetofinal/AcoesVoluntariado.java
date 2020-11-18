package pt.ipg.projetofinal;

class AcoesVoluntariado {

        private String Nome;
        private String Objetivos;
        private String ResultadosEsperados;
        private String Categoria;
        private String Responsavel;
        private String Imageurl;
        private String IdAcao;
        private String UserLogado;
        private String Link;


    public AcoesVoluntariado() {
    }

    public String getId() {
        return IdAcao;
    }

    public void setId(String id) {
        IdAcao = id;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getObjetivos() {
        return Objetivos;
    }

    public void setObjetivos(String objetivos) {
        Objetivos = objetivos;
    }

    public String getResultadosEsperados() {
        return ResultadosEsperados;
    }

    public void setResultadosEsperados(String resultadosEsperados) {
        ResultadosEsperados = resultadosEsperados;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String responsavel) {
        Responsavel = responsavel;
    }

    public String getUserLogado() {
        return UserLogado;
    }

    public void setUserLogado(String user) {
        UserLogado = user;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}

