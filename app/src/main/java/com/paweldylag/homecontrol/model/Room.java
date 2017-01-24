package com.paweldylag.homecontrol.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Pawel Dylag (pawel.dylag@estimote.com)
 */
public class Room  implements Parcelable {

  public final int id;
  public final String name;

  public Room(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel out, int flags) {
    out.writeInt(id);
    out.writeString(name);
  }

  public static final Parcelable.Creator<Room> CREATOR = new Parcelable.Creator<Room>() {
    public Room createFromParcel(Parcel in) {
      return new Room(in);
    }

    public Room[] newArray(int size) {
      return new Room[size];
    }
  };

  private Room(Parcel in) {
    id = in.readInt();
    name = in.readString();
  }
}
