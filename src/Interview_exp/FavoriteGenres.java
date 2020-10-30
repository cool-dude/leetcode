/*Given a map Map<String, List<String>> userSongs
with user names as keys and a list of all the songs
that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres,
with song genre as keys and a list of all the songs
within that genre as values. The song can only
belong to only one genre.

The task is to return a map Map<String, List<String>>,
where the key is a user name and the value is a list
 of the user's favorite genre(s). Favorite genre is
 the most listened to genre. A user can have more
 than one favorite genre if he/she has listened to
 the same number of songs per each of the genres.*/
class Sln{
    public Map<String, List<String>> favoriteGenres(
            Map<String, List<String>> userMap, Map<String, List<String>> genreMap){
        Map<String,List<String>> res=new HashMap<>();
        Map<String,String> songsToGenre=new HashMap<>();
        for(String genre:genreMap.keySet()){
            List<String> songs=genreMap.get(genre);
            for(String song:songs)
                songsToGenre.put(song,genre);
        }
        Map<String,Integer> count=new HashMap<>();
        int max=0;
        List<String> maxGenre=new ArrayList<>();
        for(String usr:userMap.keySet()){
            res.put(usr,new ArrayList<>());
            max=0;
            for(String song:songs){
                String genre=songsToGenre.get(song);
                count.put(genre,count.getOrDefault(genre)+1);
                if(max<count.get(genre)){
                    maxGenre.add(genre);
                    max=count.get(genre);
                }
            }
        }
        return res;
    }
}