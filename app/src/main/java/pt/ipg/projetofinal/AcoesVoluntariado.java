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
        private String LinkInst;
        private String Horario;
        private String Contactos;
        private String Estado;
        private String Local;


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

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getContactos() {
        return Contactos;
    }

    public void setContactos(String contactos) {
        Contactos = contactos;
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

    public void setUserLogado(String userLogado) {
        UserLogado = userLogado;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getLinkInst() {
        return LinkInst;
    }

    public void setLinkInst(String linkinst) {
        LinkInst = linkinst;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}

