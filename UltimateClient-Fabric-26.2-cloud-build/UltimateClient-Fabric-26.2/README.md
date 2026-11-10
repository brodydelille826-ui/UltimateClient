# Ultimate Client — Fabric 26.2

This is the source project for a client-side Fabric mod menu.

## Current menu

- Open the menu with **Right Shift**.
- The menu currently contains visual toggles for Fly, Speed, X-Ray, Fullbright, Night Vision, No Fall Damage, Player ESP, and Auto Sprint.
- Important: these buttons currently change their ON/OFF display only. The gameplay effects are not implemented yet.

## Build without installing programs on your computer

The project includes a GitHub Actions workflow at `.github/workflows/build.yml`. It can build the mod on GitHub's cloud runner using Java 25 and Gradle.

1. Sign in to GitHub in your web browser and create a **new repository**.
2. Upload the contents of this project folder to that repository (not just the ZIP file as one file; upload the files and folders inside it).
3. Open the repository's **Actions** tab. If prompted, enable Actions.
4. Open **Build Fabric mod** and click **Run workflow**. You can also wait for the build to run after uploading files.
5. When it finishes successfully, open the completed run and download the artifact named **UltimateClient-Fabric-26.2**.
6. Open the downloaded artifact ZIP. Put the `.jar` inside it into `%appdata%\\.minecraft\\mods`.

If the build fails, the run will show the error. A successful build is required before the JAR can be used in Minecraft.
