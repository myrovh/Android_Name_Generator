package myrovh.namegenerator;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Name
 *
 * Data storage class for the generated name. Pass in all needed values on construction and the
 * generated name will be automatically created when GetGeneratedName is called.
 */
public class Name implements Parcelable{
    String FirstName;
    String Surname;
    String MotherMaidenName;
    String Birthplace;
    String FavoriteBand;
    String GeneratedName;

    public Name() {
        FirstName = "Unknown";
        Surname = "Unknown";
        MotherMaidenName = "Unknown";
        Birthplace = "Unknown";
        FavoriteBand = "Unknown";
        GeneratedName = "Error";
    }

    public Name(String firstName, String surname, String motherMaidenName, String birthplace, String favoriteBand) {
        FirstName = firstName;
        Surname = surname;
        MotherMaidenName = motherMaidenName;
        Birthplace = birthplace;
        FavoriteBand = favoriteBand;
    }

    private void GenerateName() {
        GeneratedName = "Test";
    }

    public String GetGeneratedName() {
        if(GeneratedName == null || Objects.equals(GeneratedName, "")) {
            GenerateName();
        }
        return GeneratedName;
    }

    //region Parcel Generation
    public Name(Parcel in) {
        FirstName = in.readString();
        Surname = in.readString();
        MotherMaidenName = in.readString();
        Birthplace = in.readString();
        FavoriteBand = in.readString();
    }

    public static final Parcelable.Creator<Name> CREATOR = new Parcelable.Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }
        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(FirstName);
        parcel.writeString(Surname);
        parcel.writeString(MotherMaidenName);
        parcel.writeString(Birthplace);
        parcel.writeString(FavoriteBand);
    }
    //endregion
}
