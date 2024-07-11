# TitleAPI

Very simple TitleAPI using maven's multi-module system 

## Installing
1. Clone this repository
2. Enter the directory using `cd TitleAPI`
3. Build & install with Maven using `mvn clean install`
4. Add TitleAPI to your project's `pom.xml` under `<dependencies>`:
```xml
<dependency>
    <groupId>me.bermine.titleapi</groupId>
    <artifactId>titleapi-bukkit</artifactId>
    <version>1.0</version>
    <scope>compile</scope>
</dependency>
```

## Usage
To use TitleAPI, simply initiate it in your plugins onEnable method:
```java
import me.bermine.titleapi.TitleAPI;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        TitleAPI titleAPI = new TitleAPI(this);
        titleAPI.init();
    }
}
```

Then you can easily use TitleAPI.sendTitle method to send a title:
```java
TitleAPI.sendTitle(player, "Example title", "Example subTitle", 20L, 20L, 20L);
```
