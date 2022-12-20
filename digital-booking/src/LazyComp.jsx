let home = null;

const endpoint = 'https://fathomless-scrubland-17753.herokuapp.com/api/home';

const LazyComp = () => {
   if (!home) {
      throw new Promise(async (res, rej) => {
         const response = await fetch(endpoint);
         const { data } = await response.json();
         home = data;
         res();
      });
   }

   return <div>{home.id}</div>;
};

export default LazyComp;
