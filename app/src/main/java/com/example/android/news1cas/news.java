package com.example.android.news1cas;

/**
 * An {@link News} object contains information of each new and hyperlink to webpage.
 */

public class News {

    /**
     * information about tittle of new
     */
    private String mTittle;

    /**
     * information about section
     */
    private String mSection;

    /**
     * Website URL of the new
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param tittle  is tittle of the new ,
     * @param section is the section into new ,
     * @param url     is the website URL to find more details about the new .
     */

    public News(String tittle, String section, String url) {

        mTittle = tittle;
        mSection = section;
        mUrl = url;

    }

    /**
     * Returns tittle.
     */
    public String getmTittle() {
        return mTittle;
    }

    /**
     * Returns section.
     */
    public String getmSection() {
        return mSection;
    }

    /**
     * Returns the website URL to find more information about the new.
     */
    public String getmUrl() {
        return mUrl;
    }


}
