def favor(userSongs, songGenres):
    res = {}
    d = {s: g for g in songGenres for s in songGenres[g]}
    for name, songs in userSongs.items():
        c = collections.Counter(d[s] for s in songs if s in d)
        mxcnt = max(c.values() or [0])
        res[name] = [g for g in c if c[g] == mxcnt]
    return res