const autho = {}

autho.createToken = (tken) => {
    localStorage.setItem('miappkey',tken);
}

autho.getToken = () => {
    return localStorage.getItem('miappkey');
}

autho.isToken = () => {
    if ( localStorage.getItem('miappkey') ) {
        return true;
    } else {
        return false;
    }
}

module.exports = autho;