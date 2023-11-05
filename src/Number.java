public class Number
{
    private int denary;

    public Number(int denary)
    {
        this.denary = denary;
    }

    public int getDenary()
    {
        return this.denary;
    }

    public void setDenary(int denary)
    {
        this.denary = denary;
    }

    public String getSignedBinary()
    {
        if (this.denary >= 0)
        {
            return "0" + convertToBinary(this.denary);
        }
        else
        {
            return "1" + convertToBinary((~(-this.denary) & 0x7F) + 1);
        }
    }

    public String getHexadecimal()
    {
        if (this.denary >= 0)
        {
            return convertToHexadecimal(this.denary);
        }
        else
        {
            return convertToHexadecimal((~(-this.denary) & 0xFF) + 1);
        }
    }

    public void negate()
    {
        this.denary = -this.denary;
    }

    @Override
    public String toString()
    {
        return "Number{" +
                "denary=" + denary +
                " binary=" + getSignedBinary() +
                " hexadecimal=" + getHexadecimal() +
                "}";
    }

    private String convertToBinary(int number)
    {
        StringBuilder binary = new StringBuilder();

        while (number > 0)
        {
            binary.insert(0, (number % 2));
            number /= 2;
        }

        while (binary.length() < 7)
            binary.insert(0, "0");

        return binary.toString();
    }

    private String convertToHexadecimal(int number)
    {
        StringBuilder hex = new StringBuilder();
        while (number > 0)
        {
            int remainder = number % 16;

            if (remainder < 10)
            {
                hex.insert(0, remainder);
            }
            else
            {
                hex.insert(0, (char) (remainder - 10 + 'A'));
            }

            number /= 16;
        }
        return hex.toString();
    }
}