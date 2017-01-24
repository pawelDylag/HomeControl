package com.paweldylag.homecontrol.model;


/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class Feature {

  public final String name;
  public final int id;
  public final FeatureType type;

  public Feature(int id, String name, FeatureType type) {
    this.name = name;
    this.id = id;
    this.type = type;
  }
}
