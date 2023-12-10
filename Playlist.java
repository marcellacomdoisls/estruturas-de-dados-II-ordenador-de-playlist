public class Playlist {

  public static void run() {
    Music[] playlist = PlaylistCreator.createPlaylist();

    // Ordena a playlist por título
    quickSort(playlist, 0, playlist.length - 1, "title");
    Node rootTitle = buildTree(playlist, 0, playlist.length - 1);

    // Exibe a playlist ordenada por título
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~Playlist Ordenada por Título~~~~~~~~~~~~~~~~~~~~~~");
    displayPlaylist(rootTitle);
    System.out.println();

    // Ordena a playlist por artista
    quickSort(playlist, 0, playlist.length - 1, "artist");
    Node rootArtist = buildTree(playlist, 0, playlist.length - 1);

    // Exibe a playlist ordenada por artista
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~Playlist Ordenada por Artista~~~~~~~~~~~~~~~~~~~~~~");
    displayPlaylist(rootArtist);
    System.out.println();

    // Ordena a playlist por ano de lançamento
    quickSort(playlist, 0, playlist.length - 1, "year");
    Node rootYear = buildTree(playlist, 0, playlist.length - 1);

    // Exibe a playlist ordenada por ano de lançamento
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~Playlist Ordenada por Ano de Lançamento~~~~~~~~~~~~~~~~~~~~~~");
    displayPlaylist(rootYear);
  }

  private static void quickSort(Music[] arr, int low, int high, String sortBy) {
    if (low < high) {
      int pi = partition(arr, low, high, sortBy);

      quickSort(arr, low, pi - 1, sortBy);
      quickSort(arr, pi + 1, high, sortBy);
    }
  }

  private static int partition(Music[] arr, int low, int high, String sortBy) {
    Music pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      int compareResult = 0;

      switch (sortBy) {
        case "title":
          compareResult = arr[j].title.compareToIgnoreCase(pivot.title);
          break;
        case "artist":
          compareResult = arr[j].artist.compareToIgnoreCase(pivot.artist);
          break;
        case "year":
          compareResult = Integer.compare(arr[j].year, pivot.year);
          break;
      }

      if (compareResult < 0 || (compareResult == 0 && arr[j].title.compareToIgnoreCase(pivot.title) < 0)) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(Music[] arr, int i, int j) {
    Music temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static Node buildTree(Music[] sortedMusic, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    Node root = new Node(sortedMusic[mid]);

    root.left = buildTree(sortedMusic, start, mid - 1);
    root.right = buildTree(sortedMusic, mid + 1, end);

    return root;
  }

  private static void displayPlaylist(Node root) {
    if (root != null) {
      displayPlaylist(root.left);
      System.out.println(root.music.title + " - " + root.music.artist + " (" + root.music.year + ")");
      displayPlaylist(root.right);
    }
  }
}
