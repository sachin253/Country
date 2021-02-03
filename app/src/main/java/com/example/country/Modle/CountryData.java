package com.example.country.Modle;

public class CountryData
{
    private String Name;
    private String Capital;
    private String Flag;
    private  String Region;
    private  String SubRegion;
    private  String Population;
    private  String[] Borders;
    private  String[] Languages;

    public CountryData(String name, String capital, String flag, String region, String subRegion, String population)
    {
        Name = name;
        Capital = capital;
        Flag = flag;
        Region = region;
        SubRegion = subRegion;
        Population= population;
    }

    public CountryData()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getSubRegion() {
        return SubRegion;
    }

    public void setSubRegion(String subRegion) {
        SubRegion = subRegion;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

}
