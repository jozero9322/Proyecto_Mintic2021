const autho = {}

autho.createToken = (tken) => {
    localStorage.setItem('ecoturismo',tken);
}

autho.getToken = () => {
    return localStorage.getItem('ecoturismo');
}

autho.isToken = () => {
    if ( localStorage.getItem('ecoturismo') ) {
        return true;
    } else {
        return false;
    }
}

module.exports = autho;